package com.zelalem.mp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdaptor(var productList: ArrayList<Product>, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = productList.get(position)
        holder.bind(product, itemClickListener)
    }

    override fun getItemCount(): Int {
        return productList.size
    }



}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val productImage = itemView.product_image
    private val title = itemView.title
    private val price = itemView.price
    private val color = itemView.color

    fun bind(product: Product, clickListener: OnItemClickListener){
        title.text = product.title
        price.text = product.price.toString()
        color.text = product.color
        productImage.setImageResource(product.image)

        itemView.setOnClickListener{
            clickListener.onItemClicked(product)
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(user: Product)
}