package com.example.recyclerview.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.User

class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val viewName = itemView.findViewById<TextView>(R.id.txtName)
    val viewEmail = itemView.findViewById<TextView>(R.id.txtEmail)
    val viewAge = itemView.findViewById<TextView>(R.id.txtAge)
    fun render(item:User) {
        viewName.text = item.name
        viewEmail.text = item.email
        viewAge.text = item.age.toString()
    }
}