package com.emilkjuka.mykitchen

class Containers {
    companion object{
        val allItems: ExampleContainer = ExampleContainer(R.drawable.outline_list_alt_24 , "All Items", "All",
            ArrayList<ExampleItem>())

        val listContainers = ArrayList<ExampleContainer>()

        init{
            listContainers.add(allItems)
        }
        fun getContainers() : ArrayList<ExampleContainer>{
            return listContainers
        }

        fun addContainer(container: ExampleContainer) {
            listContainers.add(container)
        }

//        fun numberOfAllItems() : Int {
//            var counter  = 0
//            if (getContainers().size != 0) {
//                for (container in getContainers()) {
//                    counter += container.listOfItems.size
//                }
//            }
//            return counter
//        }
//
//        fun listOfAllItems(): ArrayList<ExampleItem>{
//            var allItems = ArrayList<ExampleItem>()
//            if(getContainers().size != 0) {
//                for (container in getContainers()) {
//                    for (item in container.listOfItems) {
//                        allItems.add(item)
//                    }
//                }
//            }
//            return allItems
//        }
    }
}