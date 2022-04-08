package com.example.circuittester

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.nfc.NdefRecord.createUri
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAnimations()
        buttonClick()
    }

    fun buttonAnimations(){
        //Button 1 Effects
        val textBG1: TextView = findViewById(R.id.createNewBG)
        val animateBG1: AnimationDrawable = textBG1.background as AnimationDrawable
        animateBG1.setEnterFadeDuration(2500)
        animateBG1.setExitFadeDuration(5000)

        //Button 2 Effects
        val textBG2: TextView = findViewById(R.id.loadSampleBG)
        val animateBG2: AnimationDrawable = textBG2.background as AnimationDrawable
        animateBG2.setEnterFadeDuration(2500)
        animateBG2.setExitFadeDuration(5000)

        //Button 3 Effects
        val textBG3: TextView = findViewById(R.id.loadSavedBG)
        val animateBG3: AnimationDrawable = textBG3.background as AnimationDrawable
        animateBG3.setEnterFadeDuration(2500)
        animateBG3.setExitFadeDuration(5000)

        //Begin Animations
        animateBG1.start()
        animateBG2.start()
        animateBG3.start()
    }

    fun buttonClick(){
        val newProject = findViewById<Button>(R.id.createNewProject)
        val savedProjects = findViewById<Button>(R.id.savedProjects)
        val sampleProjects = findViewById<Button>(R.id.loadSamples)
        //Background Music
        val mPlayer: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.bg_music)
        mPlayer.isLooping = true // for repeat song

        mPlayer.start()

        newProject.setOnClickListener{
            val popUp = Intent(this, PhotoChoice::class.java)
            startActivity(popUp)
            mPlayer.release()
        }

        sampleProjects.setOnClickListener{
            mPlayer.release()
        }

        savedProjects.setOnClickListener{
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
            mPlayer.release()
        }
    }
}