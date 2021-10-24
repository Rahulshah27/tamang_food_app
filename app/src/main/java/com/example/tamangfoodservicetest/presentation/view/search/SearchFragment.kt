package com.example.tamangfoodservicetest.presentation.view.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.TopRestaurantAdapter
import com.example.tamangfoodservicetest.databinding.FragmentSearchBinding
import com.example.tamangfoodservicetest.model.TopRestaurants


class SearchFragment : Fragment(R.layout.fragment_search) {


    private var topRestaurantAdapter = TopRestaurantAdapter(
        listOf(
            TopRestaurants(R.drawable.bg_search, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_search2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_search, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_search2, "Split Bread - Russian"),
            TopRestaurants(R.drawable.bg_search, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_search2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_search, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_search2, "Split Bread - Russian"),
            TopRestaurants(R.drawable.bg_search, "The Halal Guys"),
            TopRestaurants(R.drawable.bg_search2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.drawable.bg_search, "Mixt - Yerba Buena"),
            TopRestaurants(R.drawable.bg_search2, "Split Bread - Russian"),
        )
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchBinding.bind(view)

        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.rvSearchTopRestaurants.adapter = topRestaurantAdapter
        binding.rvSearchTopRestaurants.layoutManager = gridLayoutManager


        binding.tvTopCategory.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_search2_to_categoriesFragment2)

        }

        binding.tvSearchView.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_search2_to_searchItemsFragment2)

        }
    }
}