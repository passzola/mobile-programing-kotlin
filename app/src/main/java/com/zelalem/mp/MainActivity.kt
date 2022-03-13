package com.zelalem.mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()

        products.add(Product("RGA Voyger 7 16 GB Android tablet", 35.00, "Blue", R.drawable.phone, "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("HP Flyer Red 15 Laptop", 299.00, "Black & Red", R.drawable.laptop, "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("Vizio 70 classic 4k", 1298.00, "Black", R.drawable.tv, "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("Epson WorkForce WF-2750", 69.00, "Black", R.drawable.printer, "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))

        product_recycler.layoutManager = LinearLayoutManager(this)
        val adaptor = MyAdaptor(products, this)

        product_recycler.adapter = adaptor
    }

    override fun onItemClicked(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("image", product.image)
        intent.putExtra("title", product.title)
        intent.putExtra("color", product.color)
        intent.putExtra("itemId", product.itemId)
        intent.putExtra("description", product.desc)

        startActivity(intent)
    }
}