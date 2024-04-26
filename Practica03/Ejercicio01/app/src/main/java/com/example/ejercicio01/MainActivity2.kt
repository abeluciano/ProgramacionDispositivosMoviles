package com.example.ejercicio01

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imageView = findViewById<ImageView>(R.id.img)
        val textView = findViewById<TextView>(R.id.txt_imagen)

        val imagenSeleccionada = intent.getIntExtra("imagenSeleccionada", 0)
        val nombreImagen = intent.getStringExtra("nombreImagen")

        imageView.setImageResource(imagenSeleccionada)
        textView.text = nombreImagen

    }
}
