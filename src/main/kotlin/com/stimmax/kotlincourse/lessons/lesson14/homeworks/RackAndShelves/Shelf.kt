package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves

class Shelf(
    val capacity: Int,
    val item: MutableList<String>
) {

    fun addItem(name: String): Boolean {
        if (item.sumOf { it.length } + name.length <= capacity) {
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