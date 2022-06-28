package com.example.recyclerviewdemo.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.contacts.ContactAdapter.Companion.CONTACT_DATA
import com.example.recyclerviewdemo.databinding.ActivityContactInfoBinding

class ContactInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact = intent.extras?.get(CONTACT_DATA) as Contact
        binding.apply {
            name.text = contact.name
            number.text = contact.number
            pfp.setImageResource(contact.pfp)
        }
    }
}