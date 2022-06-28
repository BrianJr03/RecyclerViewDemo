package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ContactBinding

class ContactAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    lateinit var binding: ContactBinding

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ContactBinding.inflate(layoutInflater, parent, false)
        return ContactViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.apply {
            val contact = contacts[position]
            bind(contact)
        }
    }

    inner class ContactViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(contact: Contact) {
            binding.name.text = contact.name
            binding.number.text = contact.number
            binding.pfp.setImageResource(contact.pfp)
        }
    }
}

