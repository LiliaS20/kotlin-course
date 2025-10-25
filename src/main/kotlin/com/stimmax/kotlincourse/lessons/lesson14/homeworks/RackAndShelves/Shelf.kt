package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves

class Shelf(
    val capacity: Int
) {

    private val item: MutableList<String> = mutableListOf()

    fun addItem(name: String): Boolean {
        if (this.canAccommodate(name)) {
            return item.add(name)
        }
        return false
    }

    fun removeItem(name: String): Boolean {
        if (item.contains(name)) {
            return item.remove(name)
        }
        return false
    }

    fun canAccommodate(name: String): Boolean {
        return item.sumOf { it.length } + name.length <= capacity
    }

    fun containsItem(name: String): Boolean {
        return item.contains(name)
    }

    fun getItems(): List<String> {
        return item.toList()
    }
}