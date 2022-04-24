package com.example.circuittester

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.circuittester.componentsList.COMPONENT_ICON
import com.example.circuittester.componentsList.ComponentsListActivity

class BlankProject: AppCompatActivity() {
    lateinit var layout: ConstraintLayout
    lateinit var  imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blank_project_activity)

        layout = findViewById(R.id.playgroundLayout)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonHome : Button = findViewById(R.id.buttonHome)
        val buttonMic : Button = findViewById(R.id.buttonMic)
        val buttonBG : Button = findViewById(R.id.buttonBG)

        /* Listener for adding a new component */
        buttonAdd.setOnClickListener {
            addOnClick()
        }
        /* Listener for adding an audio clip*/
        buttonMic.setOnClickListener{
            micOnClick()
        }

        /* Listener for adding a background picture*/
        buttonBG.setOnClickListener {
            bgOnClick()
        }

        /* Listener for going back to main activity */
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }


        /* Get icon from ComponentsList Activity and adds it to the playground layout*/
        var bundle : Bundle?=intent.extras
        imageView = ImageView(this)

        if(bundle != null){
            var imageCode: Int = bundle.getInt(COMPONENT_ICON)
            imageView.setImageResource(imageCode)   // Set the component as an Image
            if(imageCode == R.drawable.ground || imageCode == R.drawable.voltage){
                addView(imageView, 360, 200)
            }else if( imageCode == R.drawable.led_off){
                addView(imageView, 200, 300)
            }else{
                addView(imageView, 480, 200)
            }
        }

    }

    private fun addOnClick(){
        val intent = Intent(this, ComponentsListActivity()::class.java)
        startActivity(intent)
    }

    private fun micOnClick(){

    }

    private fun bgOnClick(){

    }

    /* Parameter1 : Image to be added, Parameter 2: Width, Parameter 3: Height */
    private fun addView(imageView: ImageView, width: Int, height: Int){
        var layoutParams = ConstraintLayout.LayoutParams(width, height)
        layoutParams.setMargins(0,10,0,10)
        imageView.layoutParams = layoutParams

        layout.addView(imageView)
        moveImage(imageView) // Set event to drag the component
    }

    /* Allows the user to move an image */
    @SuppressLint("ClickableViewAccessibility")
    fun moveImage(imageView: ImageView){
        var motionX: Float = 0.0F
        var motionY: Float = 0.0F
        var dx: Float = 0.0F
        var dy: Float = 0.0F

        imageView.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN){
                motionX = motionEvent.x
                motionY = motionEvent.y
                false
            }
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                var centerY: Int = imageView.height / 2 // Middle of y-axis
                var centerX: Int = imageView.width / 2  // Middle of x-axis
            }
            if (motionEvent.action == MotionEvent.ACTION_MOVE){
                dx = motionEvent.x - motionX
                dy = motionEvent.y - motionY

                imageView.x = imageView.x + dx
                imageView.y = imageView.y + dy
                false
            }
            true
        } // End of listener
    }

}
