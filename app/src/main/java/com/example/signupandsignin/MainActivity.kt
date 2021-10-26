package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var signInbt: Button
    lateinit var signUpbt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signInbt = findViewById(R.id.button)
        signUpbt = findViewById(R.id.button2)

        signInbt.setOnClickListener {
            val intent = Intent(this , SignIn::class.java)
            startActivity(intent)
        }
        signUpbt.setOnClickListener {
            val intent = Intent(this , SignUp::class.java)
            startActivity(intent)
        }
    }
}