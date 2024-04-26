package com.example.ejercicio03


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var botonSeleccionar: Button
    private val nombresCanciones = arrayOf("Creep - Radiohead", "Ella y Él - Pedro Suarez Vertiz", "lofipop", "Snuff -  Slipknot", "Still loving you - Scorpions")
    private val canciones = arrayOf(R.raw.creep, R.raw.ella_y_el, R.raw.music, R.raw.snuff, R.raw.still_loving_you)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById<Spinner>(R.id.spinner)
        botonSeleccionar = findViewById<Button>(R.id.btn_seleccion)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresCanciones)
        spinner.adapter = adaptador

        botonSeleccionar.setOnClickListener {
            val posicion = spinner.selectedItemPosition
            val mediaPlayer = MediaPlayer.create(this, canciones[posicion])
            val intent = Intent(this, MainActivity2::class.java).apply {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                }
                putExtra("cancionSeleccionada", canciones[posicion])
            }
            startActivity(intent)
        }
    }
}
