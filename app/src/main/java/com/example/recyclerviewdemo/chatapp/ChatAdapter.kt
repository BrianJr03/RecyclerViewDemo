package com.example.recyclerviewdemo.chatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ReceiverBinding
import com.example.recyclerviewdemo.databinding.SenderBinding

class ChatAdapter(private val chats: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var bindingSenderBinding: SenderBinding
    private lateinit var bindingReceiverBinding: ReceiverBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == SENDER_VIEW) {
            bindingSenderBinding = SenderBinding.inflate(layoutInflater, parent, false)
            SenderViewHolder(bindingSenderBinding.root)
        } else {
            bindingReceiverBinding = ReceiverBinding.inflate(layoutInflater, parent, false)
            ReceiverViewHolder(bindingReceiverBinding.root)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (chats[position].viewType == SENDER_VIEW) {
            (holder as SenderViewHolder).bind(position)
        }
        else {
            (holder as ReceiverViewHolder).bind(position)
        }
    }

    override fun getItemCount() = chats.size

    override fun getItemViewType(position: Int): Int {
        return chats[position].viewType
    }

    inner class SenderViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val txtSender = bindingSenderBinding.txtSender

        fun bind(pos: Int) {
            txtSender.text = chats[pos].text
        }
    }

    inner class ReceiverViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val txtReceiver = bindingReceiverBinding.txtReceiver

        fun bind(pos: Int) {
            txtReceiver.text = chats[pos].text
        }
    }

    companion object {
        const val SENDER_VIEW = 1
    }
}