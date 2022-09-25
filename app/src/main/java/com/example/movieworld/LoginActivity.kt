package com.example.movieworld

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var login: Button
    private lateinit var facebookButton: Button
    private lateinit var googleButton: Button
    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPreferences: SharedPreferences = getSharedPreferences("MovieApp", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        facebookButton = findViewById(R.id.facebookButton)
        googleButton = findViewById(R.id.googleButton)
        counter = sharedPreferences.getInt("count", 0)
        if (counter == 1) {
            val intent: Intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        } else {
            userName = findViewById(R.id.editText_userName)
            userName.setText(sharedPreferences.getString("userName", "name").toString())
            login = findViewById(R.id.loginButton)
            login.setOnClickListener {
                editor.putString("userName", userName.text.toString())
                editor.putInt("count", 1)
                editor.apply()
                counter = sharedPreferences.getInt("count",0)
                val intent: Intent = Intent(this, MainScreen::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onPause() {

        super.onPause()
        if (counter ==1){
            finish()
        }
    }


}