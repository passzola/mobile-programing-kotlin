package com.zelalem.mp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private var score = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_app)

        findViewById<Button>(R.id.btn_reset).setOnClickListener{
            reset()
        }

        findViewById<Button>(R.id.btn_submit).setOnClickListener{
            onSubmit()
        }
    }

    private fun reset(){
        score = 0
        findViewById<RadioGroup>(R.id.radio_group).clearCheck()
        findViewById<CheckBox>(R.id.q_2_a_1).isChecked = false
        findViewById<CheckBox>(R.id.q_2_a_2).isChecked = false
        findViewById<CheckBox>(R.id.q_2_a_3).isChecked = false
    }

    fun onRadioButtonSelect(view: View){
        if(view is RadioButton){
            var cheked = view.isChecked
            when(view.getId()){
                R.id.q_1_an_1  ->
                    if(cheked)
                        score+=50
            }
        }
    }

    fun onCheckBoxSelected(view: View){
        if(view is CheckBox){
            var cheked = view.isChecked
            when(view.getId()){
                R.id.q_2_a_1  ->
                    if(cheked)
                        score+=50
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmit(){

        val current = LocalDateTime.now()
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)
        val message = if(score > 0)
            "Congratulations! You submitted on current $date and $time, You got $score%"
        else "Try again."
        val title = "Quiz App Result"
        displayDialog(title, message)
    }

    private fun displayDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    reset()
                    dialog.dismiss()
                }
            }
            builder.setMessage(message)
                .setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }
}