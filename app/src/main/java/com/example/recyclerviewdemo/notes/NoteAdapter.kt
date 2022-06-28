package com.example.recyclerviewdemo.notes

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.NoteBinding
import kotlinx.android.synthetic.main.note.view.*

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    lateinit var binding: NoteBinding

    override fun getItemCount() = notes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = NoteBinding.inflate(layoutInflater, parent, false)
        return NoteViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.apply {
            val contact = notes[position]
            bind(contact)
        }
    }

    inner class NoteViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(note: Note) {
            v.noteTitle.text = note.title
            v.noteImg.setImageResource(note.image)
        }
    }
}