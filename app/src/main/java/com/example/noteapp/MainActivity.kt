package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), iNoteAdapter {

    lateinit var  viewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer{

        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        recyclerView.adapter=adapter
    }

    override fun onItemClicked(note: Note) {

    }

}