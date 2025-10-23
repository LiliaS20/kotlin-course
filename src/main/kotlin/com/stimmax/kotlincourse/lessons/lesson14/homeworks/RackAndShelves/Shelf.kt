package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves

class Shelf(
    val capacity: Int,
    val items: MutableList<String>
) {

    fun addItem(name: String): Boolean {
        if (items.sumOf { it.length } + name.length <= capacity) {
            return items.add(name)
        }
        return false
    }

    fun removeItem(name: String): Boolean {
        if (items.contains(name)) {
            return items.remove(name)
        }
        return false
    }

    fun canAccommodate(name: String): Boolean {
        return items.sumOf { it.length } + name.length <= capacity
    }

    fun containsItem(name: String): Boolean {
        return items.contains(name)
    }

    fun getItems1(): List<String> {
        return items.toList()
    }
}