package com.emilkjuka.mykitchen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContainerActivity:AppCompatActivity() {
    var mainAdapter : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
        val container = Containers.getContainers()[intent.getStringExtra("position")?.toInt() ?: 0]

//        variables
        //val listItems = ArrayList<ExampleItem>()

        val recyclerViewContainer = this.findViewById<RecyclerView>(R.id.recycler_view_container)

        mainAdapter = ExampleAdapter(container.listOfItems)
        recyclerViewContainer.adapter = mainAdapter
        recyclerViewContainer.layoutManager = LinearLayoutManager(this)
        if (container != Containers.getContainers()[0])
        {
            val itemCreateDialog: FloatingActionButton = findViewById(R.id.button_item_create)

            itemCreateDialog.setOnClickListener {
                val dialog = ItemCreateDialog(container, mainAdapter as ExampleAdapter)
                dialog.show(supportFragmentManager, "customDialogItem")
            }
        }
        else {
            val itemCreateDialog: FloatingActionButton = findViewById(R.id.button_item_create)
            itemCreateDialog.visibility = View.GONE
        }
        (mainAdapter as ExampleAdapter).notifyDataSetChanged()
    }
}