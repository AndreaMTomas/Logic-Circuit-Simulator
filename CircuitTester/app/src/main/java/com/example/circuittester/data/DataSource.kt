package com.example.circuittester.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.circuittester.componentsList.componentsList

class DataSource(resources: Resources) {
    private val componentsList = componentsList(resources)
    private val componentsLiveData = MutableLiveData(componentsList)


    /* Returns component given an ID. */
    fun getComponentForId(id: Short): Component? {
        componentsLiveData.value?.let { components ->
            return components.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getComponentList(): LiveData<List<Component>> {
        return componentsLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}