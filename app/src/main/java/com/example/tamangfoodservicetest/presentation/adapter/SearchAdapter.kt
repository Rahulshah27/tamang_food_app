package com.example.tamangfoodservicetest.presentation.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.model.SearchList


class SearchAdapter (private val search : List<SearchList>) : RecyclerView.Adapter<SearchAdapter.SearchVH>() {

    inner class SearchVH(view: View) : RecyclerView.ViewHolder(view) {

        private val listSearch = view.findViewById<TextView>(R.id.tvItemSearch)

        init {
            with(view){
                view.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putString(Constants.Prefs.title,search[adapterPosition].search)
                    val navController: NavController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_searchItemsFragment_to_burgersFragment,bundle)

                }
            }

        }

        fun bind(searchList: SearchList){
            listSearch.text = searchList.search
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchVH {
        return SearchVH(LayoutInflater.from(parent.context).inflate(R.layout.item_search,parent,false))
    }

    override fun onBindViewHolder(holder: SearchVH, position: Int) {
        holder.bind(search[position])
    }

    override fun getItemCount(): Int {
        return search.size
    }
}