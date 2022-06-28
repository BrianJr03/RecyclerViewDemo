package com.example.recyclerviewdemo.chatapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chats: ArrayList<Chat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initRecyclerView()
    }

    private fun initData() {
        chats = ArrayList<Chat>().apply {
            add(Chat(1, "This is fun"))
            add(Chat(2, "I agree m8"))
        }
        chatAdapter = ChatAdapter(chats)

        binding.buttonReceiver.setOnClickListener {
            chats.add(Chat(1, binding.edtMessage.text.toString()))
            chatAdapter.notifyItemInserted(chats.size)
            binding.edtMessage.text?.clear()
        }

        binding.buttonSender.setOnClickListener {
            chats.add(Chat(2, binding.edtMessage.text.toString()))
            chatAdapter.notifyItemInserted(chats.size)
            binding.edtMessage.text?.clear()
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewChat.adapter = chatAdapter
    }
}