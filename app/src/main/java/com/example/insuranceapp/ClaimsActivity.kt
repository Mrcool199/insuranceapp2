package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class ClaimsActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var imageView: ImageView
    private lateinit var textView1: TextView
    private lateinit var db: DatabaseHelper
    private lateinit var username1: String // Add this line
    lateinit var Desc: EditText

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims)

        val textView = findViewById<TextView>(R.id.txtLink)
        textView.setOnClickListener {
            val intent = Intent(this, Success::class.java)
            startActivity(intent)
        }

        button = findViewById(R.id.button1)
        button2 = findViewById(R.id.AddAsset)
        imageView = findViewById(R.id.card1)
        textView1 = findViewById(R.id.textView1)

        // Move this line after initializing 'username1'
        val dbHelper = DatabaseHelper(this) // Replace 'context' with the appropriate context

        // Get a writable database
        val db = dbHelper.writableDatabase

        // Retrieve the username from the intent or wherever you set it
        username1 = LoginActivity.edituser.text.toString()

        button.setOnClickListener {
            pickImageGallery()
        }

        button2.setOnClickListener {
            val dbHelper = DatabaseHelper(this) // Replace 'context' with the appropriate context
            val db = dbHelper.writableDatabase
            val username1 = LoginActivity.edituser.text.toString()
            Desc = findViewById(R.id.textView1)
            val Descrpti = Desc.text.toString()
            dbHelper.insertData3(db, username1, Descrpti)
            Toast.makeText(this, "Claim Added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val selectedImageUri = data?.data
            imageView.setImageURI(selectedImageUri)
            imageView.tag = selectedImageUri
        }
    }
}