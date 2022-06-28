package com.example.recyclerviewdemo

import java.io.Serializable
import androidx.annotation.DrawableRes

data class Contact(val name: String, val number: String, @DrawableRes val pfp: Int) : Serializable