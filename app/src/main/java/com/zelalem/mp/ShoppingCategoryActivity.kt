package com.zelalem.mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        checkIntent()
        val productCategories = ArrayList<ProductCategory>()

        productCategories.add(ProductCategory("Electronics", R.drawable.img_electronics))
        productCategories.add(ProductCategory("Clothing", R.drawable.img_cloth))
        productCategories.add(ProductCategory("Beauty", R.drawable.img_beuaty))
        productCategories.add(ProductCategory("Food", R.drawable.img_food))

        val gridView = findViewById<GridView>(R.id.category_grid) as GridView
        val customAdaptor = CategoryAdaptor(this@ShoppingCategoryActivity, productCategories)

        // Set adaptor to ArrayList
        gridView.adapter = customAdaptor

        //On Click for GridView Item
        gridView.setOnItemClickListener { adapterView, parent, position, l ->
            Toast.makeText(this@ShoppingCategoryActivity, "You have chosen " + productCategories.get(position).category + " category of shopping", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkIntent(){
        val shoppingCategoryIntent =   intent
        val output = shoppingCategoryIntent.getStringExtra("username");
        username.text = output
    }
}