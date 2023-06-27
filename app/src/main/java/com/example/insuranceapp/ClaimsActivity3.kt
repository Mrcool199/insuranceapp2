package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper


class ClaimsActivity3: AppCompatActivity() {

    private lateinit var button3: Button
    lateinit var date1: EditText
    lateinit var time1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims3)

        val button2 = findViewById<Button>(R.id.AddAsset)
        button2.setOnClickListener {
            val intent = Intent(this, ClaimsActivity4::class.java)
            startActivity(intent)
        }
        val dropdown2 = findViewById<Spinner>(R.id.spinner2)
        val items2 = arrayOf("My vehicle was hit in the rear", "Head on collision","My Vehicle hit someone else's Vehicle", "other")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items2)
        dropdown2.adapter = adapter2

        button3 = findViewById(R.id.AddAsset)

        val dropdown = findViewById<Spinner>(R.id.spinner1)
        val items = arrayOf("Damaged while driving", "Damaged while parked", "other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown.adapter = adapter

        var selectedValue: String? = null

        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedValue = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedValue = null
            }
        }
        var selectedValue2: String? = null

        dropdown2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedValue2 = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedValue2 = null
            }
        }

        button3.setOnClickListener {
            val dropdownValue = selectedValue
            val dropdownValue2 = selectedValue2
            if (dropdownValue != null) {
                // Use the dropdownValue as needed
                val dbHelper = DatabaseHelper(this)
                val db = dbHelper.writableDatabase
                val username1 = LoginActivity.edituser.text.toString()
                if (dropdownValue2 != null) {
                    dbHelper.insertData5(db, username1, dropdownValue,dropdownValue2)
                }
                val intent1 = Intent(this, ClaimsActivity::class.java)
                startActivity(intent1)
            } else {
            }
        }
    }
}