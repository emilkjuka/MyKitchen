package com.emilkjuka.mykitchen

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment

class ItemCreateDialog(val thisContainer : ExampleContainer, val adapter : ExampleAdapter) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView : View  = inflater.inflate(R.layout.item_add_layout, container, false)
        val cancelButton : Button = rootView.findViewById<Button>(R.id.button_cancel)
        val createButton : Button = rootView.findViewById<Button>(R.id.button_create)
        cancelButton.setOnClickListener{
            dismiss()
        }
        createButton.setOnClickListener(){
            val itemName = rootView.findViewById<TextView>(R.id.input_item_name).text.toString()
            val dateCreation = rootView.findViewById<TextView>(R.id.input_item_creation_date).text.toString()
            val dateExp = rootView.findViewById<TextView>(R.id.input_item_exp_date).text.toString()

            val selected = rootView.findViewById<RadioGroup>(R.id.type_of_item).checkedRadioButtonId

            val itemImage  = when(rootView.findViewById<RadioButton>(selected).text.toString()) {
                "Food" -> R.drawable.outline_lunch_dining_20
                "Drink" -> R.drawable.outline_local_drink_24
                "Spice" -> R.drawable.outline_hourglass_empty_24
                else -> 0
            }
            thisContainer.addItem(ExampleItem(itemImage, itemName, dateCreation, dateExp))
            Containers.getContainers()[0].addItem(ExampleItem(itemImage, itemName, dateCreation, dateExp))
            adapter.notifyItemInserted(thisContainer.returnItems().size-1)
            adapter.notifyItemInserted( Containers.getContainers()[0].returnItems().size - 1 )
            dismiss()
        }
        return rootView
    }

}