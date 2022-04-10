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
import android.provider.ContactsContract
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

data class DataClass (val title: String,val subTitle:String, val imageLink: String)

class LoadSamples : Activity(){
    var array: ArrayList<DataClass> = ArrayList()
    lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_samples)
        rv = findViewById(R.id.list_item)
        addDataTo(array)
    }

    private fun addDataTo(array: ArrayList<DataClass>) {
        val data1=DataClass("AND Gate","subTitle1","https://www.attendit.net/images/easyblog_shared/July_2018/7-4-18/b2ap3_large_totw_network_profile_400.jpg")
        val data2=DataClass("NAND Gate","subTitle2","https://www.attendit.net/images/easyblog_shared/July_2018/7-4-18/b2ap3_large_totw_network_profile_400.jpg")
        val data3=DataClass("OR Gate","subTitle3","https://www.attendit.net/images/easyblog_shared/July_2018/7-4-18/b2ap3_large_totw_network_profile_400.jpg")
        array.add(data1)
        array.add(data2)
        array.add(data3)
        showInView(array)
    }

    private fun showInView(arrayWithData: java.util.ArrayList<DataClass>) {
        val adapter=Adapter(this,arrayWithData)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter=adapter
    }
}