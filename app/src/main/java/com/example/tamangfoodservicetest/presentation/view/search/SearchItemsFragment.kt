package com.example.tamangfoodservicetest.presentation.view.search

import com.example.tamangfoodservicetest.presentation.adapter.SearchAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentSearchItemsBinding
import com.example.tamangfoodservicetest.model.SearchList

class SearchItemsFragment : Fragment(R.layout.fragment_search_items) {

    private var searchAdapter = SearchAdapter(
        listOf(
            SearchList("Burgers"),SearchList("Subway"), SearchList("Sandwich"),SearchList("Pizza "),
            SearchList("Fried Rice with meat"),SearchList("Bakery"),SearchList("Cake"),SearchList("Cookies")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchItemsBinding.bind(view)

        binding.searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                val bundle = Bundle()
                bundle.putString(Constants.Prefs.title,binding.searchItem.query.toString())
                val navController: NavController = Navigation.findNavController(view)
                navController.navigate(R.id.action_searchItemsFragment2_to_burgersFragment2)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.rvSearchItems.adapter = searchAdapter
                binding.rvSearchItems.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)

                return false
            }
        })

        binding.tvSearchItemClear.setOnClickListener {
            binding.rvSearchItems.adapter = null
        }

        binding.tvSearchItemCancel.setOnClickListener {
            binding.searchItem.setQuery("",false)
            binding.rvSearchItems.adapter = null
        }

    }
}