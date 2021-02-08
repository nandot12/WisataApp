package com.udacoding.wisataapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WisataAdapter (val data :List<Wisata>) :RecyclerView.Adapter<WisataAdapter.WisataHolder>() {
    class WisataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Wisata) {
            val img = itemView.findViewById<ImageView>(R.id.img)
            val textview = itemView.findViewById<TextView>(R.id.textview)

            textview.text = get.nama_tempat


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.eidata_item,parent,false)


        val holder = WisataHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: WisataHolder, position: Int) {


        holder.bind(data.get(position))

    }

}