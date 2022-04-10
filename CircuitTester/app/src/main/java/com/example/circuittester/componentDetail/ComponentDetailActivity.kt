package com.example.circuittester.componentDetail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.circuittester.R
import com.example.circuittester.componentsList.COMPONENT_ID

class ComponentDetailActivity : AppCompatActivity() {

    private val componentDetailViewModel by viewModels<ComponentDetailViewModel>{
        ComponentDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.component_detail_activity)

        var currentComponentId: Short? = null

        /* Connect variables to UI elements */
        val componentTitle : TextView = findViewById(R.id.textDetailTitle)
        val gateImage : ImageView = findViewById(R.id.imageDetail)
        val componentDescription : TextView = findViewById(R.id.textDetailDescription)
        val truthTableImage : ImageView = findViewById(R.id.imageTruthTable)
        val buttonDetailBack : Button = findViewById(R.id.buttonDetailBack)

        val bundle: Bundle? = intent.extras
        if (bundle != null){
            currentComponentId = bundle.getShort(COMPONENT_ID)
        }

        /* Get description of each element (if its not null) */
        currentComponentId?.let {
            val currentComponent = componentDetailViewModel.getComponentForId(it)
            componentTitle.text = currentComponent?.title
            if (currentComponent != null) {
                gateImage.setImageResource(currentComponent.icon)
                truthTableImage.setImageResource(currentComponent.truthTable)
            }
            componentDescription.text = currentComponent?.description

            /* Listener for button to go back to list of components*/
            buttonDetailBack.setOnClickListener {
                finish()
            }

        }

    }
}