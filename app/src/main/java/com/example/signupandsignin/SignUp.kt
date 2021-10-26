package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var edname: EditText
    lateinit var edloc: EditText
    lateinit var edmob: EditText
    lateinit var edpw: EditText
    lateinit var submitbt : Button
    lateinit var dbhlr :DBHlr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        edname = findViewById(R.id.name)
        edloc = findViewById(R.id.location)
        edmob = findViewById(R.id.mobile)
        edpw = findViewById(R.id.password)
        submitbt = findViewById(R.id.Submitbtn)
        dbhlr = DBHlr(this)
        submitbt.setOnClickListener {
            var name = edname.text.toString()
            var mobile = edmob.text.toString()
            var location = edloc.text.toString()
            var password = edpw.text.toString()
            dbhlr.savedata(name,mobile,location,password)
            Toast.makeText(this, "Save successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , Details::class.java)
            intent.putExtra("mobile",mobile)
            //intent.putExtra("name",name)
            //intent.putExtra("location",location)
            startActivity(intent)
        }
    }
}