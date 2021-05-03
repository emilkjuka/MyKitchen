package com.emilkjuka.mykitchen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleAdapter(private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.itemImage.setImageResource(currentItem.imageResource)
        holder.itemName.text = currentItem.itemName
        holder.dateCreated.text = holder.dateCreated.text.toString() + currentItem.dateCreated
        holder.dateExp.text = holder.dateExp.text.toString() + currentItem.dateExp
    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
         val itemImage: ImageView = itemView.findViewById(R.id.item_image)
         val itemName: TextView = itemView.findViewById(R.id.item_name)
         val dateCreated: TextView = itemView.findViewById(R.id.date_created)
         val dateExp: TextView = itemView.findViewById(R.id.date_exp)
    }
}