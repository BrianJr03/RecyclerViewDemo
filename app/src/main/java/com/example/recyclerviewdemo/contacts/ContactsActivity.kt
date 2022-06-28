package com.example.recyclerviewdemo.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.ActivityContactsScreenBinding

class ContactsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsScreenBinding
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contacts: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareData()
        setAdapter()
    }

    private fun setAdapter() {
        contactAdapter = ContactAdapter(this, contacts)
        binding.apply {
            contactRecyclerView.layoutManager = LinearLayoutManager(this@ContactsActivity)
            contactRecyclerView.adapter = contactAdapter

            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val pos = viewHolder.adapterPosition
                    contacts.removeAt(pos)
                    contactAdapter.notifyItemRemoved(pos)
                    Toast.makeText(this@ContactsActivity, "Contact Deleted", Toast.LENGTH_LONG)
                        .show()
                }
            }).attachToRecyclerView(contactRecyclerView)

            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val pos = viewHolder.adapterPosition
                    contacts.removeAt(pos)
                    contactAdapter.notifyItemRemoved(pos)
                    Toast.makeText(this@ContactsActivity, "Contact Archived", Toast.LENGTH_LONG)
                        .show()
                }
            }).attachToRecyclerView(contactRecyclerView)
        }
    }

    private fun prepareData() {
        contacts = ArrayList()
        contacts.apply {
            for (i in 1..15) {
                add(
                    Contact(
                        name = "Contact $i",
                        number = "(132) 234-4556",
                        pfp = R.drawable.profile
                    )
                )
            }

        }
    }

}