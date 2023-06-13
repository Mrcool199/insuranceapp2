package com.example.insuranceapp

import android.app.DownloadManager.Request
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.insuranceapp.database.DatabaseHelper

class ClaimsActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityclaims)

        button = findViewById(R.id.button1)
        imageView = findViewById(R.id.card1)

        button.setOnClickListener{
            pickImageGallery()

            val Claimbtn = findViewById<Button>(R.id.AddAsset)

            Claimbtn.setOnClickListener {
                val intent = Intent(this, AddAsset::class.java)
                startActivity(intent)
            }

        }

    }
    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }
}
