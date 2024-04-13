package com.example.ejercicio01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgLluvia = findViewById<ImageView>(R.id.imgLluvia)

        imgLluvia.setOnClickListener(){
            var msg = "Mensaje : ${getString(R.string.msg_img)}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}