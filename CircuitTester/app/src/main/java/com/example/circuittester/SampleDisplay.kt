package com.example.circuittester

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.circuittester.samples.*

class SampleDisplay : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.samples_display)
        buttonClick()
    }

    private fun buttonClick(){
        val back = findViewById<Button>(R.id.samplesBack)
        val sample1 = findViewById<Button>(R.id.sample1button)
        val sample2 = findViewById<Button>(R.id.sample2button)
        val sample3 = findViewById<Button>(R.id.sample3button)
        val sample4 = findViewById<Button>(R.id.sample4button)
        val sample5 = findViewById<Button>(R.id.sample5button)

        sample1.setOnClickListener{
            val popUp = Intent(this, SampleOne::class.java)
            startActivity(popUp)
        }

        sample2.setOnClickListener{
            val intent = Intent(this, SampleTwo::class.java)
            startActivity(intent)
        }

        sample3.setOnClickListener{
            val popUp = Intent(this, SampleThree::class.java)
            startActivity(popUp)
        }

        sample4.setOnClickListener{
            val popUp = Intent(this, SampleFour::class.java)
            startActivity(popUp)
        }

        sample5.setOnClickListener{
            val popUp = Intent(this, SampleFive::class.java)
            startActivity(popUp)
        }

        back.setOnClickListener {
            finish()
        }
    }
}