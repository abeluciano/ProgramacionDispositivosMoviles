package com.example.ejercicio01

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var botonSeleccionar: Button
    private val nombresImagenes = arrayOf("Lluvia", "Bosque", "Caballo", "Rio", "Monte")
    private val imagenes = arrayOf(R.drawable.lluvia, R.drawable.bosque, R.drawable.caballo, R.drawable.rio, R.drawable.monte)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById<Spinner>(R.id.spinner)
        botonSeleccionar = findViewById<Button>(R.id.btn_seleccion)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresImagenes)
        spinner.adapter = adaptador

        botonSeleccionar.setOnClickListener {
            val posicion = spinner.selectedItemPosition
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("imagenSeleccionada", imagenes[posicion])
                putExtra("nombreImagen", nombresImagenes[posicion])
            }
            startActivity(intent)
        }
    }
}

