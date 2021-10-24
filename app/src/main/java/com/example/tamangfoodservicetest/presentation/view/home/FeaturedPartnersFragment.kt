package com.example.tamangfoodservicetest.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.FeaturedPartnerAdapter
import com.example.tamangfoodservicetest.model.Partners


class FeaturedPartnersFragment : Fragment(R.layout.fragment_featured_partners) {

    private var partnerAdapter = FeaturedPartnerAdapter(
        listOf(
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
            Partners(R.drawable.bg_feature_parterns, "Tacos Nanchas"),
            Partners(R.drawable.featured_bg_2, "McDonald's"),
        )
    )

    lateinit var recyclerView : RecyclerView
    private lateinit var gridLayoutManager : GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView  = view.findViewById(R.id.rv_featured_partners)
        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = partnerAdapter
        recyclerView.layoutManager = gridLayoutManager

    }

}