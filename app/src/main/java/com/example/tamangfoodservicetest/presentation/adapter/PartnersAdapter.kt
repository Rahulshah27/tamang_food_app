package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.BestPartners

class PartnersAdapter(private val partners:  List<BestPartners>) :
    RecyclerView.Adapter<PartnersAdapter.PartnersVH>() {

    inner class PartnersVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.iv_features)
        private val itemsName = view.findViewById<TextView>(R.id.tv_features_title)
        private val itemsLocation = view.findViewById<TextView>(R.id.tv_features_location)

        fun bind(partners: BestPartners) {
            imageView.setImageResource(partners.bestPartnersImage)
            itemsName.text = partners.bestPartnersName
            itemsLocation.text = partners.bestPartnersLocation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnersVH {
        return PartnersVH(LayoutInflater.from(parent.context).inflate(R.layout.list_horizontal_features,parent,false))
    }

    override fun onBindViewHolder(holder: PartnersVH, position: Int) {
        holder.bind(partners[position])
    }

    override fun getItemCount(): Int {
        return partners.size
    }
}