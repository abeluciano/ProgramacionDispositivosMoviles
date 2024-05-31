package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.UsersAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }
    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        val usersRecycler = findViewById<RecyclerView>(R.id.list_users)
        usersRecycler.layoutManager = manager
        usersRecycler.adapter = UsersAdapter(UserProvider.list_users)
        usersRecycler.addItemDecoration(decoration)
    }
}