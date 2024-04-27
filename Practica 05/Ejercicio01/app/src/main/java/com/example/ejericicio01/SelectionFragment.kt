package com.example.ejercicio01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.ejericicio01.R

class SelectionFragment : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var botonSeleccionar: Button
    private val nombresImagenes = arrayOf("Lluvia", "Bosque", "Caballo", "Rio", "Monte")
    private val imagenes = arrayOf(R.drawable.lluvia, R.drawable.bosque, R.drawable.caballo, R.drawable.rio, R.drawable.monte)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_selection, container, false)

        spinner = view.findViewById<Spinner>(R.id.spinner)
        botonSeleccionar = view.findViewById<Button>(R.id.btn_seleccion)

        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, nombresImagenes)
        spinner.adapter = adaptador

        botonSeleccionar.setOnClickListener {
            val posicion = spinner.selectedItemPosition
            (activity as MainActivity).replaceFragments(imagenes[posicion], nombresImagenes[posicion])
        }

        return inflater.inflate(R.layout.fragment_selection, container, false)
    }
}
