package com.example.insuranceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class ProfileActivity : AppCompatActivity() {

    private lateinit var dbh: DatabaseHelper
    val username1 = LoginActivity.edituser.text.toString()

    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityprofile)

        dbh = DatabaseHelper(this)

        val cursor = dbh.getText()
        if (cursor != null && cursor.moveToFirst()) {
            val usernameColumnIndex = cursor.getColumnIndex("username")
            val emailColumnIndex = cursor.getColumnIndex("Email")
            val PhoneNumberColumnIndex = cursor.getColumnIndex("PhoneNumber")

            var foundUsername = false

            do {
                val username = cursor.getString(usernameColumnIndex)
                val email = cursor.getString(emailColumnIndex)
                val PhoneNumber = cursor.getString(PhoneNumberColumnIndex)

                if (username ==username1) {
                    foundUsername = true
                    val textView1 = findViewById<TextView>(R.id.fullName_field)
                    textView1.text = "Username: $username"

                    val textView4 = findViewById<TextView>(R.id.phoneNo_field)
                    textView4.text = "$PhoneNumber"

                    val textView2 = findViewById<TextView>(R.id.email_field)
                    textView2.text = "$email"
                    break
                }
            } while (cursor.moveToNext())

            if (!foundUsername) {
                Toast.makeText(this, "No contact found for the provided username", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No contacts available", Toast.LENGTH_SHORT).show()
        }
        val button3 = findViewById<Button>(R.id.cancel)
        button3.setOnClickListener {
            val intent = Intent(this, Success::class.java)
            startActivity(intent)
        }
    }
}