package com.example.tamangfoodservicetest.presentation.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.model.AllRestaurants
import com.example.tamangfoodservicetest.presentation.view.home.RestaurantActivity

class HomeRestaurantsAdapter (private val allRestaurants:  List<AllRestaurants>) :
    RecyclerView.Adapter<HomeRestaurantsAdapter.RestaurantsVH>() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    inner class RestaurantsVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.iv_restaurant)
        private val itemsName = view.findViewById<TextView>(R.id.tv_restaurant_title)

        init {
            with(view){
                view.setOnClickListener {

                    sharedPreferences =
                        this.context.getSharedPreferences(Constants.Prefs.image, Context.MODE_PRIVATE)

                    editor = sharedPreferences.edit()

                    editor.apply{
                        putInt("image", allRestaurants[adapterPosition].allRestaurantsImage)
                        putString("title", allRestaurants[adapterPosition].allRestaurantsName)
                    }.apply()

                    val intent = Intent(this.context, RestaurantActivity::class.java)
                    this.context.startActivity(intent)
                }
            }
        }

        fun bind(allRestaurants: AllRestaurants) {
            imageView.setImageResource(allRestaurants.allRestaurantsImage)
            itemsName.text = allRestaurants.allRestaurantsName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        return RestaurantsVH(LayoutInflater.from(parent.context).inflate(R.layout.list_restaurants_items,parent,false))
    }

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {
        holder.bind(allRestaurants[position])
    }

    override fun getItemCount(): Int {
        return allRestaurants.size
    }
}