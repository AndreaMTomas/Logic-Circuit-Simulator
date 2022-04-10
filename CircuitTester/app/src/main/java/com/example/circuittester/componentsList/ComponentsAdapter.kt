package com.example.circuittester.componentsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.circuittester.R
import com.example.circuittester.data.Component

class ComponentsAdapter(private val onClick: (Component) -> Unit, private val addElement: (Component) -> Unit):
    ListAdapter<Component, ComponentsAdapter.ComponentViewHolder>(ComponentDiffCallback) {

    class ComponentViewHolder(itemView: View, val onClick: (Component) -> Unit, val addElement: (Component) -> Unit):
        RecyclerView.ViewHolder(itemView){

        /* Connect variables to UI */
        private val componentTitle: TextView = itemView.findViewById(R.id.component_title)
        private val componentImageView: ImageView = itemView.findViewById(R.id.image_component)
        private val buttonAbout: Button = itemView.findViewById(R.id.button_about)
        private var currentComponent: Component? = null

        init{
            //Set event for button about (it should open the component info)
            buttonAbout.setOnClickListener {
                currentComponent?.let {
                    onClick(it)
                }
            }

            itemView.setOnClickListener {
                /* HERE SHOULD ADD THE ELEMENT TO THE MAIN SCREEN*/
                currentComponent?.let {
                    addElement(it)
                }
            }
        } // End of Init



        fun bind(component: Component){
            currentComponent = component
            componentTitle.text = component.title
            componentImageView.setImageResource(component.icon)
        }

    }

    /* Creates and inflates view and returns ComponentViewHolder*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.component_item, parent, false)
        return ComponentViewHolder(view, onClick, addElement)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val component = getItem(position)
        holder.bind(component)
    }

}

object ComponentDiffCallback : DiffUtil.ItemCallback<Component>() {
    override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem.id == newItem.id
    }
}