package com.example.recyclerview.adapter

import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.User

class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val viewName = itemView.findViewById<TextView>(R.id.txtName)
    val viewEmail = itemView.findViewById<TextView>(R.id.txtEmail)
    val viewAge = itemView.findViewById<TextView>(R.id.txtAge)
    val btnDelete = itemView.findViewById<Button>(R.id.btnDelete)

    fun render(item:User, l:OnClickListener, onClickListener: (User) -> Unit) {
        viewName.text = item.name
        viewEmail.text = item.email
        viewAge.text = item.age.toString()
        btnDelete.setOnClickListener(l)
        itemView.setOnClickListener {
            onClickListener(item)
        }
    }
}