package com.example.tamangfoodservicetest.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.AllRestaurantsAdapter
import com.example.tamangfoodservicetest.databinding.FragmentAllRestaurantBinding
import com.example.tamangfoodservicetest.model.AllRestaurants


class AllRestaurantFragment : Fragment(R.layout.fragment_all_restaurant) {

    private var allRestaurantsAdapter = AllRestaurantsAdapter(
        listOf(
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "Mayfield Bakery & Cafe")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAllRestaurantBinding.bind(view)

        binding.rvAllRestaurants.adapter = allRestaurantsAdapter
        binding.rvAllRestaurants.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)

    }

}