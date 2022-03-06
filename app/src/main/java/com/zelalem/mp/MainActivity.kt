package com.zelalem.mp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.walmart_login.*

class MainActivity : AppCompatActivity() {
    private val registeredUsers = mutableListOf<User>(User("Zelalme", "Mekuria", "zelalem@gmail.com", "zelalem"),
    User("Henok", "Chekol", "henok@gmail.com", "henok"),
    User("eskinder", "Abebe", "eskinder@gmail.com", "eskinder"),
    User("Mintesnot", "Desalgi", "minte@gmail.com", "minte"),
    User("Amanuel", "Chorito", "aman@gmail.com", "aman"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.walmart_login)

        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Using Kotlin null check
                if(result.data?.hasExtra("user")!!){
                    registeredUsers.add(result.data?.getSerializableExtra("user") as User)
                }
            }
        }

        btn_create_account.setOnClickListener{
            onCreateAccount(resultLauncher)
        }
    }

    // On signup
    fun onLogin(view: View){
        val email = findViewById<EditText>(R.id.email).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()

        val user = getUserInfo(email, password)

        if(user != null){
            val intent = Intent(this, ShoppingCategoryActivity::class.java)
            intent.putExtra("username",user.userName )


            startActivity(intent)
        }
    }

    // forgot password
    fun onForgotPassword(view: View){
        val userEmail = email.text.trim().toString()

        val user = getUserByUsername(userEmail)

        if(user != null){
            var to = arrayOf(userEmail)
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sending lost password")
            intent.putExtra(Intent.EXTRA_EMAIL, to)
            intent.putExtra(Intent.EXTRA_TEXT, user.password)

            startActivity(intent)
        }
    }

    // on create account
    fun onCreateAccount(launcher: ActivityResultLauncher<Intent>){
        val registrationIntent = Intent(this, RegisterActivity::class.java)
        launcher.launch(registrationIntent)
    }

    private fun getUserInfo(username: String, password: String): User?{
        var userInfo: User? = null

        for (user in registeredUsers){
            if(user.userName == username && user.password == password){
                userInfo = user
            }
        }

        return userInfo
    }

    private fun getUserByUsername(userName: String?): User?{

        var existingUser: User? = null

        for(user in registeredUsers){
            if(user.userName == userName){
                existingUser = user
            }
        }

        return existingUser
    }
}