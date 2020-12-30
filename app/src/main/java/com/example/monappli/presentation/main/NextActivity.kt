package com.example.monappli.presentation.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monappli.R
import com.example.monappli.data.repository.Food
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_next.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class NextActivity : AppCompatActivity(){
    private val client = OkHttpClient()
    private var mfood = listOf<Food>()
    private lateinit var adapter: ListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "myApp"
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_next)
        linearLayoutManager = LinearLayoutManager(this)
        list_recycler_view.layoutManager = linearLayoutManager


        //showList();
        var foodList = listOf<Food>()
        foodList= getDataFromCache()


        if (foodList.isNullOrEmpty()) {
            //Toast.makeText(getApplicationContext(), "Liste existe", Toast.LENGTH_SHORT).show();
            mfood = run("https://raw.githubusercontent.com/MjuM/ProjectAndroid/master/dataFinal.json")


        } else {
            // Toast.makeText(getApplicationContext(), "Liste existe pas", Toast.LENGTH_SHORT).show();
            adapter = ListAdapter(foodList)



            runOnUiThread { list_recycler_view.adapter = adapter }
        }

    }
    private fun saveList(foodList: List<Food>) {
        var gson = Gson()
         sharedPref = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        val jsonString: String = gson.toJson(foodList)
        sharedPref
            .edit()
            .putString(PREF_NAME, jsonString)
            .apply()
        //Toast.makeText(getApplicationContext(), "Liste sauvegarde", Toast.LENGTH_SHORT).show();
    }
    private fun getDataFromCache(): List<Food> {
        sharedPref  = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        val jsonFood = sharedPref.getString(PREF_NAME, null)
        var gson = Gson()
        return if (jsonFood == null) {

           return listOf<Food>()
        } else {
            val listType =
                object : TypeToken<List<Food>>() {}.type
           return gson.fromJson(jsonFood, listType)
        }
    }
    fun run(url: String): List<Food> {


        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                var responses = client.newCall(request).execute();
                val jsonData = responses.body()!!.string()
                val Jobject = JSONObject(jsonData)
                val Jarray = Jobject.getJSONArray("ingredients")
                var tempName : String
                var tempIngr : String
                var mfood = listOf<Food>()
                for (i in 0 until Jarray.length()-1) {
                    tempName = Jarray.getJSONObject(i).getString("name")
                    println(tempName)
                    tempIngr = Jarray.getJSONObject(i).getString("ingredient1")
                    mfood += Food(tempName,tempIngr)
                }

                adapter = ListAdapter(mfood)

                println(mfood.size)
                saveList(mfood)
                runOnUiThread { list_recycler_view.adapter = adapter }

            }
        })

        return mfood
    }











}