package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHlr(context: Context?) : SQLiteOpenHelper(context, "details.db", null, 1) {
    val sql :SQLiteDatabase = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table Account(Name text , Mobile text , Location text , Password text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedata(s1: String, s2: String, s3: String, s4: String){
        val cv = ContentValues()
        cv.put("Name", s1)
        cv.put("Mobile", s2)
        cv.put("Location", s3)
        cv.put("Password", s4)
        sql.insert("Account", null, cv)
    }

    @SuppressLint("Range")
    fun retrive(s1:String) : account {
        val cursor: Cursor = sql.query("Account",null,"Mobile=?", arrayOf(s1),null,null,null)
        cursor.moveToFirst()
                val name: String = cursor.getString(cursor.getColumnIndex("Name"))
                val mobile: String = cursor.getString(cursor.getColumnIndex("Mobile"))
                val location: String = cursor.getString(cursor.getColumnIndex("Location"))
                val password: String = cursor.getString(cursor.getColumnIndex("Password"))
        val obj = account(name,mobile,location,password)
        return obj
    }

    @SuppressLint("Range")
    fun check(s1:String,s2:String) : account {
        val cursor: Cursor = sql.query("Account",null,"Mobile=?", arrayOf(s1),null,null,null)
        var list = account("", "", "", "")
        if(cursor.count>0) {
            cursor.moveToFirst()
            val mobile: String = cursor.getString(cursor.getColumnIndex("Mobile"))
            val password: String = cursor.getString(cursor.getColumnIndex("Password"))
            if (mobile == s1 && password == s2) {
                val name: String = cursor.getString(cursor.getColumnIndex("Name"))
                val location: String = cursor.getString(cursor.getColumnIndex("Location"))
                list = account(name, mobile, location, password)
            } else {
                //    Toast.makeText(this, "Not correct", Toast.LENGTH_SHORT).show()
                list = account("", mobile, "", password)
            }
        }else{
            list =  account("", "", "", "")
        }
        return list
    }
}

/*
    @SuppressLint("Range")
    fun retrive(s1:String) :String {
        var c :Cursor = sql.query("notes", null, "Note=?", arrayOf(s1), null, null, null)
        c.moveToFirst()
        var note = c.getString(c.getColumnIndex("Note"))
        return note
        }
 */