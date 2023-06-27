package com.example.insuranceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class EmergencyActivity : AppCompatActivity() {

    private lateinit var dbh: DatabaseHelper
    val username1 = LoginActivity.edituser.text.toString()

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityemergency)
    }
}