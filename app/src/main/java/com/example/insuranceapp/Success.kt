package com.example.insuranceapp

import ProfileActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Success : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success)

        val textView = findViewById<TextView>(R.id.txtLink)
        textView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.Profile)
        button.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.Addclaim)
        button2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.AddAsset)
        button3.setOnClickListener {
            val intent = Intent(this, AddAsset::class.java)
            startActivity(intent)
        }
    }
}
