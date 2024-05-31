package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.UsersAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var userAdapter:UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        eventos()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Toast.makeText(view?.context, "Atras Personalizado", Toast.LENGTH_SHORT).show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun eventos(){
        val btnAdd = requireActivity().findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAdd?.setOnClickListener(){
            val u1 = User("Test", 20," asdsad", "bljjsdbq")
            userAdapter.addUser(u1)
        }
    }
    fun initRecyclerView() {
        val manager = LinearLayoutManager(view?.context)
        userAdapter = UsersAdapter(UserProvider.list_users) { user ->
            onItemSelected(user)
        }
        val decoration = DividerItemDecoration(view?.context,manager.orientation)
        val usersRecycler = requireActivity().findViewById<RecyclerView>(R.id.list_users)
        usersRecycler.layoutManager = manager
        usersRecycler.adapter = userAdapter
        usersRecycler.addItemDecoration(decoration)
    }

    private fun onItemSelected(user: User){
        Toast.makeText(view?.context, "${user.name} --- ${user.email}", Toast.LENGTH_LONG).show()
    }
}