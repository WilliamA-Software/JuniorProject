package com.example.juniorprojectapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.juniorprojectapplication.data.model.Beer
import com.example.juniorprojectapplication.R
import com.example.juniorprojectapplication.databinding.ItemBeerBinding

class BeerAdapter(private val beers: MutableList<Beer>, private val onClickListener:(Beer)->Unit) : RecyclerView.Adapter<BeerViewHolder>(){

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        return BeerViewHolder(layoutInflater.inflate(R.layout.item_beer, parent, false))
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = beers[position]
        holder.render(beer, onClickListener)
    }

    override fun getItemCount(): Int = beers.size

}