package com.example.productapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter ( private val myList: List<String>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val nome = myList[position]
        holder.textName.text = nome
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.findViewById(R.id.txtName)
    }
}
