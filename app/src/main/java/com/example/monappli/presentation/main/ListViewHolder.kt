package com.example.monappli.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monappli.R
import com.example.monappli.data.repository.Food

class ListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout, parent, false)) {
    private var mNameView: TextView? = null
    private var mSpeciesView: TextView? = null

    init {
        mNameView= itemView.findViewById(R.id.firstLine)
        mSpeciesView = itemView.findViewById(R.id.secondLine)
    }

    fun bind(food: Food) {
        mNameView?.text = food.name
        mSpeciesView?.text = food.ingredient
    }

}