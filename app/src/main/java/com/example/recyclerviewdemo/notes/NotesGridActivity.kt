package com.example.recyclerviewdemo.notes

import android.os.Bundle
import com.example.recyclerviewdemo.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityNotesGridBinding

class NotesGridActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesGridBinding
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var noteList: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesGridBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
    }

    private fun setAdapter() {
        initData()
        noteAdapter = NoteAdapter(noteList)
        binding.apply {
            notesRecyclerView.layoutManager = GridLayoutManager(this@NotesGridActivity, 3)
            notesRecyclerView.adapter = noteAdapter
        }
    }

    private fun initData() {
        noteList = ArrayList()
        for (i in 1..15) {
            noteList.add(
                Note(
                    "Note $i",
                    if (i % 2 == 0) R.drawable.speaker_note else R.drawable.event
                )
            )
        }
    }
}