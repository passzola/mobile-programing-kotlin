package com.zelalem.mp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btn_register.setOnClickListener{
            onRegister()
        }
    }

    /*

    show success message
    add get the user info and send to the Main Activity
    and add to the registered user array list

     */

    // user registration
    private fun onRegister(){
        val firstName = first_name.text.trim().toString()
        val lastName = last_name.text.trim().toString()
        val email = registration_email.text.trim().toString()
        val password = password.text.trim().toString()

        // validate input
        if((firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())){
            // Construct user information
            Toast.makeText(this@RegisterActivity, "Account created successfully", Toast.LENGTH_LONG).show()
            val user = User(firstName, lastName, email, password)
            // Send the Main Activity

            val intent = Intent()

            intent.putExtra("user", user)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}