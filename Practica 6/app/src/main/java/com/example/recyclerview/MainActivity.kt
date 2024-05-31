package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.UsersAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter:UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        eventos()
    }

    private fun eventos(){
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAdd.setOnClickListener(){
            val u1 = User("Test", 20," asdsad", "bljjsdbq")
        userAdapter.addUser(u1)
        }
    }
    fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        userAdapter = UsersAdapter(UserProvider.list_users) { user ->
            onItemSelected(user)
        }
        val decoration = DividerItemDecoration(this,manager.orientation)
        val usersRecycler = findViewById<RecyclerView>(R.id.list_users)
        usersRecycler.layoutManager = manager
        usersRecycler.adapter = userAdapter
        usersRecycler.addItemDecoration(decoration)
    }

    private fun onItemSelected(user: User){
        Toast.makeText(this, "${user.name} --- ${user.email}", Toast.LENGTH_LONG).show()
    }
}