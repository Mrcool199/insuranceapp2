package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class ClaimsActivity4: AppCompatActivity() {

    private lateinit var button2: Button
    lateinit var Street1: EditText
    lateinit var Post1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims4)

        val textView = findViewById<TextView>(R.id.txtLink)
        textView.setOnClickListener {
            val intent = Intent(this, Success::class.java)
            startActivity(intent)
        }

        button2 = findViewById(R.id.AddAsset)

        button2.setOnClickListener {
            val dbHelper = DatabaseHelper(this)
            val db = dbHelper.writableDatabase
            val username1 = LoginActivity.edituser.text.toString()
            Post1 = findViewById(R.id.year)
            Street1 = findViewById(R.id.Street)
            val Street1 = Street1.text.toString()
            val Post1 = Post1.text.toString()
            dbHelper.insertData5(db, username1, Street1, Post1)
            val intent1 = Intent(this, ClaimsActivity::class.java)
            startActivity(intent1)
        }
    }
}