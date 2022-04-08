package com.example.circuittester

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.widget.TextView
import org.w3c.dom.Text
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.nfc.NdefRecord.createUri
import android.util.DisplayMetrics
import android.widget.Button

class PhotoChoice : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_choice)
        buttonClick()
    }

    fun buttonClick() {
        val photoProject = findViewById<Button>(R.id.photoProject)
        val blankProject = findViewById<Button>(R.id.blankProject)
    }
}