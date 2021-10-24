package com.example.tamangfoodservicetest.presentation.view.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.CategoriesAdapter
import com.example.tamangfoodservicetest.databinding.FragmentCategoriesBinding
import com.example.tamangfoodservicetest.model.Categories


class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var categoriesAdapter = CategoriesAdapter(
        listOf(
            Categories(R.drawable.bg_categary, "Fast Food"),
            Categories(R.drawable.bg_category2, "Breakfast & Brunch"),
            Categories(R.drawable.bg_categary, "Mexican"),
            Categories(R.drawable.bg_category2, "Bakery"),
            Categories(R.drawable.bg_categary, "Deserts"),
            Categories(R.drawable.bg_category2, "Burgers"),
            Categories(R.drawable.bg_categary, "Fast Food"),
            Categories(R.drawable.bg_category2, "Breakfast & Brunch"),
            Categories(R.drawable.bg_categary, "Mexican"),
            Categories(R.drawable.bg_category2, "Bakery"),
            Categories(R.drawable.bg_categary, "Fast Food"),
            Categories(R.drawable.bg_category2, "Breakfast & Brunch"),
            Categories(R.drawable.bg_categary, "Mexican"),
            Categories(R.drawable.bg_category2, "Bakery"),
            Categories(R.drawable.bg_categary, "Deserts"),
            Categories(R.drawable.bg_category2, "Burgers"),
            Categories(R.drawable.bg_categary, "Fast Food"),
            Categories(R.drawable.bg_category2, "Breakfast & Brunch"),
            Categories(R.drawable.bg_categary, "Mexican"),
            Categories(R.drawable.bg_category2, "Bakery"),
        )
    )

    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCategoriesBinding.bind(view)

        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.rvCategories.adapter = categoriesAdapter
        binding.rvCategories.layoutManager = gridLayoutManager

    }
}