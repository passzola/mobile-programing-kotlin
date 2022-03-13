package com.zelalem.mp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdaptor(var productList: ArrayList<Product>): RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdaptor.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdaptor.MyViewHolder, position: Int) {
        holder.itemView.title.text = productList[position].title
        holder.itemView.price.text = productList[position].price.toString()
        holder.itemView.color.text = productList[position].color
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}