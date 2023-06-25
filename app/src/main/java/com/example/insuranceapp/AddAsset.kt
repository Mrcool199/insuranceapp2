package com.example.insuranceapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.insuranceapp.database.DatabaseHelper

class AddAsset : AppCompatActivity() {
    private lateinit var carmod: EditText
    private lateinit var yearr: EditText
    private lateinit var Lisence: EditText
    private lateinit var Dateinsur: EditText
    private lateinit var Desc: EditText
    private lateinit var addAssetbtn: Button
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addasset)

        val textView = findViewById<TextView>(R.id.txtLink)
        textView.setOnClickListener {
            val intent = Intent(this, Success::class.java)
            startActivity(intent)
        }

        carmod = findViewById(R.id.carmodel)
        yearr = findViewById(R.id.year)
        Lisence = findViewById(R.id.Licenceplate)
        Dateinsur = findViewById(R.id.dateinsured)
        Desc = findViewById(R.id.description)
        addAssetbtn = findViewById(R.id.registerbutton)
        db = DatabaseHelper(this)

        addAssetbtn.setOnClickListener() {
            val carmodtext = carmod.text.toString()
            val yearrtext = yearr.text.toString()
            val Lisencetext = Lisence.text.toString()
            val Dateinsurtext = Dateinsur.text.toString()
            val savedata = db.insertdata2(carmodtext, yearrtext, Lisencetext, Dateinsurtext)

            if (TextUtils.isEmpty(
                    yearrtext
                )
            ) {
                Toast.makeText(
                    this,
                    "Missing something",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (savedata == true) {
                    Toast.makeText(this, "Added asset", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Details already inserted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
