package com.zelalem.mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.table_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout)
    }



    fun onAdd(view: View){
        // Creating new row
        val tableRow = TableRow(this)

        val txtVersion = TextView(this)
        txtVersion.text = android_version.text.toString().trim()

        val txtCodeName = TextView(this)
        txtCodeName.text = code_name.text.toString().trim()

        // Setting layout params

        val colOne = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 6, 8, 0)
        }

        txtVersion.setBackgroundResource(R.color.table_row_bg)
        txtVersion.layoutParams = colOne

        val colTwo = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 6, 0, 0)
        }

        txtCodeName.setBackgroundResource(R.color.table_row_bg)
        txtCodeName.layoutParams = colTwo


        tableRow.addView(txtVersion, 0)
        tableRow.addView(txtCodeName, 1)
        tbl_phone_info.addView(tableRow)

        // Reset input control after insertion
        resetField()
    }


    private fun resetField(){
        android_version.setText("")
        code_name.setText("")
    }
}