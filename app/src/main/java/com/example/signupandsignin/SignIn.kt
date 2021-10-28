package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var btlogin: Button
    lateinit var edmobile: EditText
    lateinit var edpassword: EditText
    lateinit var dbhlr :DBHlr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btlogin = findViewById(R.id.btlogin)
        edmobile = findViewById(R.id.edm)
        edpassword = findViewById(R.id.edpw)
        dbhlr = DBHlr(this)
        btlogin.setOnClickListener {
            if (edmobile.text.isEmpty() || edpassword.text.isEmpty())
                Toast.makeText(this, "Fill all fileds please!!", Toast.LENGTH_SHORT).show()
            else {
                var list = dbhlr.check(edmobile.text.toString(), edpassword.text.toString())
                if (list.name != "") {
                    val intent = Intent(this, Details::class.java)
                    intent.putExtra("mobile", edmobile.text.toString())
                    //intent.putExtra("name",name)
                    //intent.putExtra("location",location)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}