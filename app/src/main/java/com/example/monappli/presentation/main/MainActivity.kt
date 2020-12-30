package com.example.monappli.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.monappli.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succes")
                        .setMessage("Connexion")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    val intent = Intent(this, NextActivity::class.java)
                    startActivity(intent)

                }//Navigation
               LoginCreate -> {
                   MaterialAlertDialogBuilder(this)
                       .setTitle("Create")
                       .setMessage("Vous avez créer votre compte")
                       .setPositiveButton("Ok") { dialog, which ->
                           dialog.dismiss()
                       }
                       .show()

                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("compte incconu")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_account_button.setOnClickListener{
            mainViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
        }



    }
}
