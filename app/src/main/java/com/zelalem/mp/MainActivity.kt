package com.zelalem.mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()

        products.add(Product("RGA Voyger 7 16 GB Android tablet", 35.00, "Blue", "phone", "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("HP Flyer Red 15 Laptop", 299.00, "Black & Red", "laptop", "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("Vizio 70 classic 4k", 1298.00, "Black", "tv", "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))
        products.add(Product("Epson WorkForce WF-2750", 69.00, "Black", "printer", "34567", "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since"))

        product_recycler.layoutManager = LinearLayoutManager(this)
        val adaptor = MyAdaptor(products)

        product_recycler.adapter = adaptor

        // when user click on the recycler item get all the item and pass to the next activity
    }
}