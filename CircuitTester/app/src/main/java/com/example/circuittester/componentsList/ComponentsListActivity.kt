package com.example.circuittester.componentsList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.circuittester.BlankProject
import com.example.circuittester.R
import com.example.circuittester.componentDetail.ComponentDetailActivity
import com.example.circuittester.data.Component

const val COMPONENT_ID = "component id"
const val COMPONENT_ICON = "component icon"
class ComponentsListActivity: AppCompatActivity(){

    private val componentsListViewModel by viewModels<ComponentsListViewModel> {
        ComponentsListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.components_list_activity)

        //val componentsAdapter = ComponentsAdapter {component -> adapterOnClick(component)}
        val componentsAdapter = ComponentsAdapter({component -> adapterOnClick(component) }, {component -> addComponent(component) })
        val concatAdapter = ConcatAdapter(componentsAdapter)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewList)
        recyclerView.adapter = concatAdapter

        componentsListViewModel.componentsLiveData.observe(this){
            it?.let {
                componentsAdapter.submitList(it as MutableList<Component>)
            }
        }
        // Back button
        val actionbarMainActivity = supportActionBar
        // Set actionbar title
        actionbarMainActivity!!.title = "Components list"
        // Set back button
        actionbarMainActivity.setDisplayHomeAsUpEnabled(true)
        actionbarMainActivity.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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