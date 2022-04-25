package com.example.circuittester.samples

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.circuittester.R

class SampleOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_one)
        buttonClick()
    }

    private fun buttonClick(){
        val back = findViewById<Button>(R.id.sample1Back)
        val input1 = findViewById<CheckBox>(R.id.s1b1)
        val input2 = findViewById<CheckBox>(R.id.s1b2)
        val image = findViewById<ImageView>(R.id.s1Led)

        if (input1.isChecked && input2.isChecked){
            image.setImageResource(R.drawable.led_off)
        } else if (input1.isChecked && !input2.isChecked){
            image.setImageResource(R.drawable.led_on)
        } else if (!input1.isChecked && input2.isChecked){
            image.setImageResource(R.drawable.led_on)
        }

        back.setOnClickListener {
            finish()
        }
    }
}