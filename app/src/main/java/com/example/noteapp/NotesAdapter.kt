package com.example.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context, val listner:iNoteAdapter) : RecyclerView.Adapter<NotesAdapter.noteViewHolder>(){

    val allNotes = ArrayList<Note>()
    inner class noteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.addNote)
        val deleteButton = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        val viewHolder=noteViewHolder(LayoutInflater.from(context).inflate(R.layout.items,parent,false))

        viewHolder.deleteButton.setOnClickListener{
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text= currentNote.text
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

}
//to handle click we have to make interface
interface iNoteAdapter{
    fun onItemClicked(note:Note)
}