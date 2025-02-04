package com.example.productapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter ( private val myList: List<Products>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = myList[position]
        holder.textName.text = product.name
        holder.imageView.setImageResource(product.drawable)
        holder.textPrice.text = "R$ ${product.price}"

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.findViewById(R.id.txtName)
        val imageView: ImageView = itemView.findViewById(R.id.imgProduct)
        val textPrice: TextView = itemView.findViewById(R.id.txtPrice)
    }
}
