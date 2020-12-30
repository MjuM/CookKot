package com.example.monappli.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.monappli.data.repository.Food

class ListAdapter(private val list: List<Food>)
    : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food: Food = list[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int = list.size

}