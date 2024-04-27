package com.example.ejercicio01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ejericicio01.R

class DisplayFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_display, container, false)

        val imageView = view.findViewById<ImageView>(R.id.img)
        val textView = view.findViewById<TextView>(R.id.txt_imagen)

        val imagenSeleccionada = arguments?.getInt("imagenSeleccionada") ?: 0
        val nombreImagen = arguments?.getString("nombreImagen")

        imageView.setImageResource(imagenSeleccionada)
        textView.text = nombreImagen

        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    companion object {
        fun newInstance(imagenSeleccionada: Int, nombreImagen: String): DisplayFragment {
            val fragment = DisplayFragment()
            val args = Bundle()
            args.putInt("imagenSeleccionada", imagenSeleccionada)
            args.putString("nombreImagen", nombreImagen)
            fragment.arguments = args
            return fragment
        }

    }
}
