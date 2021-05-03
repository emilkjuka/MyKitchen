package com.emilkjuka.mykitchen

import android.content.Context
import android.media.ImageReader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView

class ContainerCreateDialog (val adapter : RecyclerView.Adapter<ExampleContainerAdapter.ExampleViewHolder>): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView : View  = inflater.inflate(R.layout.container_add_layout, container, false)
        val cancelButton : Button = rootView.findViewById<Button>(R.id.button_cancel)
        val createButton : Button = rootView.findViewById<Button>(R.id.button_create)
        cancelButton.setOnClickListener{
            dismiss()
        }
        createButton.setOnClickListener(){
            val selected = rootView.findViewById<RadioGroup>(R.id.container_type).checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selected)

            val containerName = rootView.findViewById<TextView>(R.id.input_item_name)
            val itemListPerContainer = ArrayList<ExampleItem>()

            val typeOfContainer : String =  radio.text.toString()

            val containerImage  = when(typeOfContainer) {
                "Fridge" -> R.drawable.outline_kitchen_24
                "Cabinet" -> R.drawable.outline_inventory_2_24
                "Drawer" -> R.drawable.outline_inbox_24
                else -> 0
            }
            Containers.addContainer(ExampleContainer(containerImage, containerName.text.toString(),typeOfContainer,  itemListPerContainer))
            adapter.notifyItemInserted(Containers.getContainers().size-1)
            dismiss()
        }
        return rootView
    }

}