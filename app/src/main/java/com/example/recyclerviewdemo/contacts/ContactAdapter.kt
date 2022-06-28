package com.example.recyclerviewdemo.contacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.contacts.Contact
import com.example.recyclerviewdemo.databinding.ContactBinding
import kotlinx.android.synthetic.main.activity_contact_info.view.*
import kotlin.coroutines.coroutineContext

class ContactAdapter(private val context: Context, private val contacts: List<Contact>) :
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
            itemView.setOnClickListener {
                val intent = Intent(context, ContactInfoActivity::class.java)
                intent.putExtra(CONTACT_DATA, contact)
                context.startActivity(intent)
            }
        }
    }

    inner class ContactViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(contact: Contact) {
            v.name.text = contact.name
            v.number.text = contact.number
            v.pfp.setImageResource(contact.pfp)
        }
    }

    companion object {
        const val CONTACT_DATA = "contact"
    }
}

