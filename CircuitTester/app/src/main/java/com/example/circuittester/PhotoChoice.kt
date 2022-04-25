package com.example.circuittester

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class PhotoChoice : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_choice)
        buttonClick()
    }

    private fun buttonClick() {
        val photoProject = findViewById<Button>(R.id.photoProject)
        val blankProject = findViewById<Button>(R.id.blankProject)
        blankProject.setOnClickListener {
            val intent = Intent(this, BlankProject::class.java)
            startActivity(intent)
        }
    }
}