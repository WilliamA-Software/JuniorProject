package com.example.juniorprojectapplication.ui.adapters

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.juniorprojectapplication.data.model.Beer
import com.example.juniorprojectapplication.databinding.ItemBeerBinding

class BeerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding= ItemBeerBinding.bind(view)

    fun render(beerModel: Beer, onClickListener:(Beer)->Unit){
        binding.tvNameBeer.text = beerModel.name
        Glide.with(binding.ivBeer.context).load(beerModel.imageUrl).into(binding.ivBeer)

        binding.ivBeer.setOnClickListener{ onClickListener(beerModel) }
        //itemView.setOnClickListener { onClickListener(beerModel) }

    }
}