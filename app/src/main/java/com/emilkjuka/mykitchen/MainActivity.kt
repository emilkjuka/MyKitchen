package com.emilkjuka.mykitchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AlertDialogLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ExampleContainerAdapter.onItemClickListener {

    var mainAdapter : RecyclerView.Adapter<ExampleContainerAdapter.ExampleViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewMain = this.findViewById<RecyclerView>(R.id.recycler_view_main)
        mainAdapter =  ExampleContainerAdapter(Containers.getContainers(), this)
        recyclerViewMain.adapter = mainAdapter
        recyclerViewMain.layoutManager = LinearLayoutManager(this)

        val buttonCreateContainer : FloatingActionButton = findViewById(R.id.button_cabinet_create)
        buttonCreateContainer.setOnClickListener{
            val dialog = ContainerCreateDialog(mainAdapter as ExampleContainerAdapter)
            dialog.show(supportFragmentManager, "customDialogContainer")

        }

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: ExampleContainer = Containers.getContainers()[position]
        val intent =Intent(this, ContainerActivity::class.java)
        intent.putExtra("position", position.toString())
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
        (mainAdapter as ExampleContainerAdapter).notifyDataSetChanged()
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        (mainAdapter as ExampleContainerAdapter).notifyDataSetChanged()
    }

}