package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var tvname: TextView
    lateinit var tvloc: TextView
    lateinit var tvmobile: TextView
    lateinit var signOutbt: Button
    lateinit var dbhlr :DBHlr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val intent = intent
        //val name = intent.getStringExtra("name")
        val mobile = intent.getStringExtra("mobile")
        //val loc = intent.getStringExtra("location")
        signOutbt = findViewById(R.id.signOutbt)
        tvname = findViewById(R.id.tvname)
        tvloc = findViewById(R.id.tvloc)
        tvmobile = findViewById(R.id.tvmobile)
        dbhlr = DBHlr(this)
        var obj = dbhlr.retrive(mobile!!)
        tvmobile.text = tvmobile.text.toString() +mobile
        tvloc.text = obj.location
        tvname.text = obj.name

        signOutbt.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

    }
}