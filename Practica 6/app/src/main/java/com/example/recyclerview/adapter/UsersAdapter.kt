package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.User

class UsersAdapter(var items:MutableList<User>, val onItemSelected: (User) -> Unit):RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = items[position]
        holder.render(item, {deleteUser(position)}, onItemSelected)
    }

    fun addUser(user: User){
        items.add(0, user)
        notifyItemInserted(0)
    }

    fun deleteUser(index:Int){
        items.removeAt(index)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index,items.size)
    }
    fun editUser(index: Int, user: User){
        items[index]=user
        notifyItemChanged(index)
    }
}