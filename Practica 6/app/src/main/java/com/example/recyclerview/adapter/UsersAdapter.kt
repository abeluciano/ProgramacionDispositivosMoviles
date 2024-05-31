package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.User

class UsersAdapter(val items:List<User>):RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }
}