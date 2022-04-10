package com.example.circuittester.componentDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.circuittester.data.Component
import com.example.circuittester.data.DataSource


class ComponentDetailViewModel (private val dataSource: DataSource) : ViewModel() {

    fun getComponentForId(id: Short) : Component? {
        return dataSource.getComponentForId(id)
    }
}

class ComponentDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ComponentDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ComponentDetailViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}