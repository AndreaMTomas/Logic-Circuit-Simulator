package com.example.circuittester.samples

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.circuittester.R

class SampleFive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_five)
        buttonClick()
    }

    private fun buttonClick(){
        val back = findViewById<Button>(R.id.sample5Back)
        val input1 = findViewById<CheckBox>(R.id.s5b1)
        val input2 = findViewById<CheckBox>(R.id.s5b2)
        val input3 = findViewById<CheckBox>(R.id.s5b3)
        val input4 = findViewById<CheckBox>(R.id.s5b4)
        val image = findViewById<ImageView>(R.id.s5Led)

        if (input3.isChecked && !input4.isChecked){
            image.setImageResource(R.drawable.led_on)
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