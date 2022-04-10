package com.example.circuittester

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class Adapter(private val context: Context, private val list: ArrayList<DataClass>) : RecyclerView.Adapter<Adapter.MyVH>() {

    //Creating View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        return MyVH(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    }

    //Setting Data in View
    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val data=list[position]
        holder.itemView.findViewById<TextView>(R.id.title).text = data.title
        holder.itemView.findViewById<TextView>(R.id.sub_title).text = data.subTitle
        Picasso.get().load(data.imageLink).fit().placeholder(R.mipmap.ic_launcher).into(holder.itemView.findViewById<ImageView>(R.id.image))
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"You Clicked On ${data.title}",Toast.LENGTH_SHORT).show()
        }
    }

    //Returns Size Of Array List
    override fun getItemCount(): Int {
        return list.size
    }

    //ViewHolder For List Item
    class MyVH (itemView: View):
        RecyclerView.ViewHolder(itemView)
}
