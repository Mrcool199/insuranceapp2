package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class ClaimsActivity2: AppCompatActivity() {

    private lateinit var button2: Button
    lateinit var date1: EditText
    lateinit var time1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims2)

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
            time1 = findViewById(R.id.time)
            date1 = findViewById(R.id.date)
            val date1 = date1.text.toString()
            val time1 = time1.text.toString()
            dbHelper.insertData4(db, username1, date1, time1)
            val intent1 = Intent(this, ClaimsActivity3::class.java)
            startActivity(intent1)
        }
    }
}