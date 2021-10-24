package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.Partners

class FeaturedPartnerAdapter(private val partners : List<Partners>) :
    RecyclerView.Adapter<FeaturedPartnerAdapter.PartnerVH>() {

    inner class PartnerVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.iv_featured_partners)
        private val partnerName = view.findViewById<TextView>(R.id.tv_featured_partners_title)

        fun bind(partners: Partners){
            imageView.setImageResource(partners.partnerImage)
            partnerName.text = partners.partnerName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnerVH {
        return PartnerVH(LayoutInflater.from(parent.context).inflate(R.layout.list_featured_parteners,parent,false))
    }

    override fun onBindViewHolder(holder: PartnerVH, position: Int) {
        holder.bind(partners[position])
    }

    override fun getItemCount(): Int {
        return partners.size
    }
}