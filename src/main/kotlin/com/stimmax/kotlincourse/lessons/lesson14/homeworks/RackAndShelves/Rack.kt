package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves

import kotlin.collections.sumOf

class Rack(
    val countShelf: Int
) {

    private val shelves: MutableList<Shelf> = mutableListOf()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size + 1 <= countShelf || !shelves.contains(shelf)) {
            return shelves.add(shelf)
        }
        return false
    }

    fun removeShelf(index: Int): List<String> {
        lateinit var list: List<String>
        if (shelves.size >= index - 1) {
            list = shelves[index].getItems()
            shelves.removeAt(index)
        } else {
            list = emptyList()
        }
        return list
    }

    fun addItem(name: String): Boolean {
        shelves.forEach {
            if (it.canAccommodate(name)) {
                return it.addItem(name)
            }
        }
        return false
    }

    fun removeItem(name: String): Boolean {
        shelves.forEach {
            if (it.containsItem(name)) {
                return it.removeItem(name)
            }
        }
        return false
    }

    fun containsItem(name: String): Boolean {
        for (shelf in shelves) {
            return shelf.containsItem(name)
        }
        return false
    }

    fun getShelves1(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        for (i in 0 until shelves.size) {
            println(
                """                
                Индекс: $i
                Вместимость: ${shelves[i].capacity}
                Оставшаяся вместимость: ${shelves[i].capacity - shelves[i].getItems().sumOf { it.length }}
                Список предметов: ${shelves[i].getItems()}
                """.trimIndent()
            )
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }

        val shelfIndex = shelves[index].getItems()
        shelves.removeAt(index)

        val sortedShelves = shelves.sortedByDescending { it.capacity }.toMutableList()
        val shelvesRemove = mutableListOf<String>()
        var isAdded = false

        for (item in shelfIndex) {
            for (shelf in sortedShelves) {
                if (shelf.canAccommodate(item)) {
                    isAdded = shelf.addItem(item)
                    break
                }
            }
            if (!isAdded) {
                shelvesRemove.add(item)
                isAdded = false
            }
        }

        return shelvesRemove.toList()
    }

    fun advancedRemoveShelf1(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        val otherShelves = shelves - shelves[index]
        for (item in shelves[index].getItems()) {
            if (otherShelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        shelves.removeAt(index)
        return notReplacedItems.toList()
    }
}
