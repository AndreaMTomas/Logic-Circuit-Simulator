package com.example.circuittester.data

import androidx.annotation.DrawableRes

data class Component(
    val id: Short,
    var name: String,   // Used to display the name of the gate in the recycler view
    var title: String, // Used to show the truth table
    var description: String,
    @DrawableRes
    var icon: Int,
    var truthTable: Int)