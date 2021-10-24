package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.ImageList

class HomeViewPagerAdapter(private val images : List<ImageList>) : RecyclerView.Adapter<HomeViewPagerAdapter.HomeVH>() {
    inner class HomeVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.iv_slider_homepage)

        fun bind(images : ImageList){
            imageView.setImageResource(images.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        return HomeVH(LayoutInflater.from(parent.context).inflate(R.layout.slide_item_homepage_container,parent,false))
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}