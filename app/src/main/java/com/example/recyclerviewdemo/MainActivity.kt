package com.example.recyclerviewdemo

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewdemo.chatapp.ChatActivity
import com.example.recyclerviewdemo.contacts.ContactsActivity
import com.example.recyclerviewdemo.databinding.ActivityMainBinding
import com.example.recyclerviewdemo.notes.NotesGridActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myChatBtn.setOnClickListener{
            startActivity(Intent(this, ChatActivity::class.java))
        }

        binding.myContacts.setOnClickListener{
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        binding.myNotes.setOnClickListener{
            startActivity(Intent(this, NotesGridActivity::class.java))
        }
    }
}