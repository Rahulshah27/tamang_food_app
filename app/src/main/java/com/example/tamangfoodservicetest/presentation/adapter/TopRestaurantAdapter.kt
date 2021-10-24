package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.TopRestaurants

class TopRestaurantAdapter  (private val topRestaurants: List<TopRestaurants>) :
    RecyclerView.Adapter<TopRestaurantAdapter.RestaurantsVH>() {

    inner class RestaurantsVH (view: View) : RecyclerView.ViewHolder(view){

        private val imageView = view.findViewById<ImageView>(R.id.imageRVRestaurants)
        private val categoryName = view.findViewById<TextView>(R.id.tvRVRestaurantName)

        fun bind(topRestaurants: TopRestaurants){
            imageView.setImageResource(topRestaurants.topRestaurantsImage)
            categoryName.text = topRestaurants.topRestaurantsName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        return RestaurantsVH(LayoutInflater.from(parent.context).inflate(R.layout.list_item_top_restaurant,parent,false))


    }

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {

        holder.bind(topRestaurants[position])

    }

    override fun getItemCount(): Int {

        return topRestaurants.size
    }
}