package com.emilkjuka.mykitchen

class ExampleContainer(val imageResource: Int, val containerName : String, val containerType : String , val listOfItems : ArrayList<ExampleItem>){

    public fun addItem(item : ExampleItem){
        this.listOfItems.add(item)
    }

    public fun returnItems() : ArrayList<ExampleItem> = listOfItems

}
