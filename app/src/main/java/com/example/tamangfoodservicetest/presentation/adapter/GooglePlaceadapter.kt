package com.example.tamangfoodservicetest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tamangfoodservicetest.R
import com.google.android.libraries.places.api.model.AutocompletePrediction
import kotlinx.android.synthetic.main.recycler_places.view.*


class GooglePlaceadpater(val callback:(String)->Unit):RecyclerView.Adapter<GooglePlaceadpater.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.recycler_places, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        autocompletePredictionList?.get(position)?.let { holder.bind(it) }

    }
    override fun getItemCount() = autocompletePredictionList?.size ?: 0
    var autocompletePredictionList:List<AutocompletePrediction>?=null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class VH(itemView: View): RecyclerView.ViewHolder(itemView){
        init {
            with(itemView){

                setOnClickListener {
                    callback.invoke(
                        autocompletePredictionList?.get(adapterPosition)?.getPrimaryText(null)
                            .toString())
                }
            }
        }
        fun bind(data: AutocompletePrediction){
            with(itemView){
                kotlin.runCatching {
                    tvName.text = data.getPrimaryText(null)
                    tvCity.text = data.getSecondaryText(null)
                }.onFailure {
                    Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}