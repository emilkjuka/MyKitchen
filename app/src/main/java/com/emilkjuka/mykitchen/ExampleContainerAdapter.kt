package com.emilkjuka.mykitchen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleContainerAdapter(private val exampleList: List<ExampleContainer>, val listener : onItemClickListener) : RecyclerView.Adapter<ExampleContainerAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_container,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.containerImage.setImageResource(currentItem.imageResource)
        holder.containerName.text = currentItem.containerName
        holder.containerType.text = "Type of container: " + currentItem.containerType
        holder.numberOfItems.text = "Items inside: "+ currentItem.returnItems().size.toString()
    }

    override fun getItemCount() = exampleList.size

    inner class ExampleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val containerImage: ImageView = itemView.findViewById(R.id.container_image)
        val containerName: TextView = itemView.findViewById(R.id.container_name)
        val containerType : TextView = itemView.findViewById(R.id.type_of_container)
        val numberOfItems : TextView = itemView.findViewById(R.id.number_items)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position= adapterPosition
            if ( position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }
        interface onItemClickListener {
            fun onItemClick(position: Int)
        }

}