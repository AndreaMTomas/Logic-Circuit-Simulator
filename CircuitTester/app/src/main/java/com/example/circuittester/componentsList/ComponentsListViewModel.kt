package com.example.circuittester.componentsList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.circuittester.data.DataSource

class ComponentsListViewModel(val dataSource: DataSource): ViewModel() {

    val componentsLiveData = dataSource.getComponentList()


}
class ComponentsListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ComponentsListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ComponentsListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}