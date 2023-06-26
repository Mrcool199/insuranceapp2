package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper


class ClaimsActivity3: AppCompatActivity() {

    private lateinit var button3: Button
    lateinit var Street1: EditText
    lateinit var Post1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims3)

        val button2 = findViewById<Button>(R.id.AddAsset)
        button2.setOnClickListener {
            val intent = Intent(this, ClaimsActivity4::class.java)
            startActivity(intent)
        }
        val dropdown = findViewById<Spinner>(R.id.spinner1)
        val items = arrayOf("Damaged while driving", "Damaged while parked", "other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter
        val dropdown2 = findViewById<Spinner>(R.id.spinner2)
        val items2 = arrayOf("My vehicle was hit in the rear", "Head on collision","My Vehicle hit someone else's Vehicle", "other")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items2)
        dropdown2.adapter = adapter2

        button3 = findViewById(R.id.AddAsset)

        button3.setOnClickListener {
            val intent1 = Intent(this, ClaimsActivity::class.java)
            startActivity(intent1)
        }
    }
}