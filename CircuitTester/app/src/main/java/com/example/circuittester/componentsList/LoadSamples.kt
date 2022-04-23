package com.example.circuittester.componentsList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.circuittester.BlankProject
import com.example.circuittester.R
import com.example.circuittester.componentDetail.ComponentDetailActivity
import com.example.circuittester.data.Component
import androidx.appcompat.widget.Toolbar

class LoadSamples : AppCompatActivity() {

    // Problem is that these components are loading in so that they can be added as items, fix this
    // tomorrow by reverting back to your default list and pulling from the components list
    // individually
    private val componentsListViewModel by viewModels<ComponentsListViewModel> {
        ComponentsListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_samples)

        //val componentsAdapter = ComponentsAdapter {component -> adapterOnClick(component)}
        val componentsAdapter = ComponentsAdapter({component -> adapterOnClick(component) }, {component -> addComponent(component) })
        val concatAdapter = ConcatAdapter(componentsAdapter)
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.adapter = concatAdapter

        componentsListViewModel.componentsLiveData.observe(this){
            it?.let {
                componentsAdapter.submitList(it as MutableList<Component>)
            }
        }
    }

    private fun adapterOnClick(component: Component) {
        val intent = Intent(this, ComponentDetailActivity()::class.java)
        intent.putExtra(COMPONENT_ID, component.id)
        startActivity(intent)
    }

    private fun addComponent(component: Component){
        val intent = Intent(this, BlankProject()::class.java)
        intent.putExtra(COMPONENT_ICON, component.icon )
        setResult(Activity.RESULT_OK, intent)
        startActivity(intent)
    }



}