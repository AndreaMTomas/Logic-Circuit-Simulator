package com.example.circuittester

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream


class PhotoChoice : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_choice)
        buttonClick()
    }

    val CAMERA_PERMISSION_CODE = 1
    val CAMERA_REQUEST_CODE = 2

    fun buttonClick() {
        val photoProject = findViewById<Button>(R.id.photoProject)
        val blankProject = findViewById<Button>(R.id.blankProject)
        blankProject.setOnClickListener {
            val intent = Intent(this, BlankProject::class.java)
            startActivity(intent)
        }
        photoProject.setOnClickListener{
            val pm: PackageManager = this.getPackageManager()
            val deviceHasCameraFlag = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
            if(!deviceHasCameraFlag) {
                Toast.makeText(applicationContext, "No Camera detected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, BlankProject::class.java)
                startActivity(intent)
            }
            if(deviceHasCameraFlag) {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, CAMERA_REQUEST_CODE)
                }
                else{
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),
                        CAMERA_PERMISSION_CODE)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }else{
                Toast.makeText(this, "Permission for Camera was denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQUEST_CODE){
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                val intent = Intent(this, BlankProject::class.java)
                //val img = BitmapDrawable(resources, imageBitmap)


                //Convert bitmap to byte array to send to different activity
                //without taking up too much memory
                val stream = ByteArrayOutputStream()
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                val byteArray: ByteArray = stream.toByteArray()
                intent.putExtra("image", byteArray)

                startActivity(intent)
            }
        }
    }
}