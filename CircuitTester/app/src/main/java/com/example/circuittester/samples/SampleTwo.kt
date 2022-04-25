package com.example.circuittester.samples

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.circuittester.R

class SampleTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_two)
        buttonClick()
    }

    private fun buttonClick(){
        val back = findViewById<Button>(R.id.sample2Back)
        val input1 = findViewById<CheckBox>(R.id.s2b1)
        val input2 = findViewById<CheckBox>(R.id.s2b2)
        val input3 = findViewById<CheckBox>(R.id.s2b3)
        val image = findViewById<ImageView>(R.id.s2Led)

        if (input1.isChecked && input2.isChecked && input3.isChecked){
            image.setImageResource(R.drawable.led_off)
        } else if (input1.isChecked && !input2.isChecked && input3.isChecked){
            image.setImageResource(R.drawable.led_on)
        } else if (!input1.isChecked && input2.isChecked && input3.isChecked){
            image.setImageResource(R.drawable.led_on)
        }

        back.setOnClickListener {
            finish()
        }
    }
}