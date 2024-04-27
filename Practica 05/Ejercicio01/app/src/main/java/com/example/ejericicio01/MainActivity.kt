package com.example.ejercicio01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SelectionFragment())
                .commit()
        }
    }

    fun replaceFragments(imagenSeleccionada: Int, nombreImagen: String) {
        val displayFragment = DisplayFragment.newInstance(imagenSeleccionada, nombreImagen)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, displayFragment)
            .addToBackStack(null)
            .commit()
    }
}
