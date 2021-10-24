package com.example.tamangfoodservicetest.presentation.view.home

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.SingleRestaurantAdapter
import com.example.tamangfoodservicetest.databinding.FragmentSingleRestaurantTabBinding
import com.example.tamangfoodservicetest.model.SingleRestaurant


class SingleRestaurantTabFragment : Fragment(R.layout.fragment_single_restaurant_tab) {

    private var singleRestaurantAdapter1 = SingleRestaurantAdapter(
        listOf(
            SingleRestaurant(
                R.drawable.bg_food, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.bg_food, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.bg_food, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            )
        )
    )

    private var singleRestaurantAdapter2 = SingleRestaurantAdapter(
        listOf(
            SingleRestaurant(
                R.drawable.bg_food, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.bg_food, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.bg_food, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.drawable.food2, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSingleRestaurantTabBinding.bind(view)

        binding.rvTabSingleRestaurant.adapter = singleRestaurantAdapter1
        binding.rvTabSingleRestaurant.isNestedScrollingEnabled = false
        binding.rvTabSingleRestaurant.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        binding.rvTabSingleRestaurant1.adapter = singleRestaurantAdapter2
        binding.rvTabSingleRestaurant1.isNestedScrollingEnabled = false
        binding.rvTabSingleRestaurant1.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

    }
}