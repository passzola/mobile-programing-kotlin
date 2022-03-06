package com.zelalem.mp

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CategoryAdaptor(context:Context, productCategories: ArrayList<ProductCategory>): BaseAdapter() {

    var context = context
    var productCategory = productCategories

    override fun getCount(): Int {
        return productCategory.size
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(postion: Int, convertView: View?, parent: ViewGroup?): View {
        var categoryView = convertView
        var categoryViewHolder: ViewHolder

        if(categoryView == null){
            val categoryInflator = (context as Activity).layoutInflater

            categoryView = categoryInflator.inflate(R.layout.activity_grid_view_items, parent, false)

            categoryViewHolder = ViewHolder()

            categoryViewHolder.categoryImage = categoryView!!.findViewById<ImageView>(R.id.category_image) as ImageView
            categoryViewHolder.categoryText = categoryView!!.findViewById<TextView>(R.id.category_name) as TextView

            //Set A Tag to Identify our view.
            categoryView.setTag(categoryViewHolder)
        }else {
            categoryViewHolder = categoryView.getTag() as ViewHolder
        }

        categoryViewHolder.categoryImage!!.setImageResource(productCategory.get(postion).image)

        categoryViewHolder.categoryText!!.setText(productCategory.get(postion).category)

        return categoryView
    }

    class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryText: TextView? = null
    }
}