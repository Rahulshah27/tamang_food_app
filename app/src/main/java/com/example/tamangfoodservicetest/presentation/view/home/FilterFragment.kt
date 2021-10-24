package com.example.tamangfoodservicetest.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.databinding.FragmentFilterBinding
import com.example.tamangfoodservicetest.util.showToast

class FilterFragment : Fragment(R.layout.fragment_filter) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFilterBinding.bind(view)

        binding.tvClearAll.setOnClickListener {
            binding.chipCategories.clearCheck()
        }
        binding.tvClearAllDietary.setOnClickListener {
            binding.chipDietary.clearCheck()
        }
        binding.tvClearAllPrice.setOnClickListener {
            binding.chipPriceRange.clearCheck()
        }

        binding.btnApplyFilters.setOnClickListener {
            this.context?.showToast("Filters are Applied")

            requireActivity().onBackPressed()
        }

    }

}