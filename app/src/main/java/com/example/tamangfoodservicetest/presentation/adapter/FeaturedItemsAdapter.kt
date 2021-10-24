package com.example.tamangfoodservicetest.presentation.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.model.Partners

class FeaturedItemsAdapter (private val partners : List<Partners>) :
    RecyclerView.Adapter<FeaturedItemsAdapter.PartnerVH>() {

    inner class PartnerVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.imageFeaturedItems)
        private val partnerName = view.findViewById<TextView>(R.id.tvFeaturedItemsName)

        fun bind(partners: Partners){
            imageView.setImageResource(partners.partnerImage)
            partnerName.text = partners.partnerName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnerVH {
        return PartnerVH(LayoutInflater.from(parent.context).inflate(R.layout.list_item_featured_items,parent,false))
    }

    override fun onBindViewHolder(holder: PartnerVH, position: Int) {
        holder.bind(partners[position])
    }

    override fun getItemCount(): Int {
        return partners.size
    }
}