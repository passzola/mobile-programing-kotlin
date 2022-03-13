package com.zelalem.mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val intent = intent

        findViewById<ImageView>(R.id.product_detail_image).setImageResource(intent.getIntExtra("image", 1))
        findViewById<TextView>(R.id.product_title).text = intent.getStringExtra("title")
        findViewById<TextView>(R.id.product_id).text = intent.getStringExtra("itemId")
        findViewById<TextView>(R.id.product_color).text = intent.getStringExtra("color")
        findViewById<TextView>(R.id.product_desc).text = intent.getStringExtra("description")
    }
}