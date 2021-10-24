package com.example.tamangfoodservicetest.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.TopRestaurantAdapter
import com.example.tamangfoodservicetest.databinding.FragmentTopRestaurantBinding
import com.example.tamangfoodservicetest.model.TopRestaurants

class TopRestaurantFragment : Fragment(R.layout.fragment_top_restaurant) {

    private var topRestaurantAdapter = TopRestaurantAdapter(
        listOf(
            TopRestaurants(R.drawable.bg_top1, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_toptop2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_top3, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_top1, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_toptop2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_top3, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_top1, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_toptop2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_top3, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_top1, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_toptop2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_top3, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_top1, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_toptop2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_top3, "Mixt - Yerba Buena")
        )
    )

    private lateinit var gridLayoutManager : GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTopRestaurantBinding.bind(view)

        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.rvTopRestaurants.adapter = topRestaurantAdapter
        binding.rvTopRestaurants.layoutManager = gridLayoutManager

    }
}