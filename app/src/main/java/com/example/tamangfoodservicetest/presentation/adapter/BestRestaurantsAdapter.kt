package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.BestRestaurants


class BestRestaurantsAdapter (private val bestRestaurants:  List<BestRestaurants>) :
    RecyclerView.Adapter<BestRestaurantsAdapter.RestaurantsVH>() {

    inner class RestaurantsVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.iv_features)
        private val itemsName = view.findViewById<TextView>(R.id.tv_features_title)
        private val itemsLocation = view.findViewById<TextView>(R.id.tv_features_location)

        fun bind(bestRestaurants:  BestRestaurants) {
            imageView.setImageResource(bestRestaurants.bestRestaurantsImage)
            itemsName.text = bestRestaurants.bestRestaurantsName
            itemsLocation.text = bestRestaurants.bestRestaurantsLocation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        return RestaurantsVH(LayoutInflater.from(parent.context).inflate(R.layout.list_horizontal_features,parent,false))
    }

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {
        holder.bind(bestRestaurants[position])
    }

    override fun getItemCount(): Int {
        return bestRestaurants.size
    }
}