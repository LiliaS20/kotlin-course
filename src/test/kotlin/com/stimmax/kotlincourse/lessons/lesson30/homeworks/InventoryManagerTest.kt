package com.stimmax.kotlincourse.lessons.lesson30.homeworks


import org.example.com.stimmax.kotlincourse.lessons.lesson30.homeworks.InventoryManager
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InventoryManagerTest {

    private val inventoryManager = InventoryManager(10)

    @Test
    fun addNewItemBalls() {
        inventoryManager.addItem("Мяч", 3)
        assertEquals(3, inventoryManager.getItemCount("Мяч"))
    }

    @Test
    fun addBallsCountTest() {
        inventoryManager.addItem("Мяч", 3)
        inventoryManager.addItem("Мяч", 2)
        assertEquals(5, inventoryManager.getItemCount("Мяч"))
    }

    @Test
    fun addNewItemDumbbellsTest() {
        inventoryManager.addItem("Мяч", 5)
        inventoryManager.addItem("Гантели", 5)
        assertEquals(5, inventoryManager.getItemCount("Мяч"))
    }

    @Test
    fun addItemCountMoreCapacityTest() {
        assertThrows(IllegalStateException::class.java) {
            inventoryManager.addItem("Гантели", 1)
        }
    }

    @Test
    fun addNewItemRacketsMoreCapacityTest() {
        assertThrows(IllegalStateException::class.java) {
            inventoryManager.addItem("Ракетка", 11)
        }
    }

    @Test
    fun getBallsTest() {
        inventoryManager.addItem("Мяч", 5)
        assertEquals(5, inventoryManager.getItemCount("Мяч"))
    }

    @Test
    fun getRacketsTest() {
        inventoryManager.addItem("Ракетка", 11)
        assertEquals(0, inventoryManager.getItemCount("Ракетка"))
    }

    @Test
    fun removeItemCountTest() {
        inventoryManager.addItem("Мяч", 5)
        assertEquals(true, inventoryManager.removeItem("Мяч", 1))
    }

    @Test
    fun removeItemMoreCountTest() {
        assertEquals(false, inventoryManager.removeItem("Мяч", 6))
    }

    @Test
    fun removeAllItemTest() {
        inventoryManager.addItem("Мяч", 4)
        assertEquals(true, inventoryManager.removeItem("Мяч", 4))
    }

    @Test
    fun getBallsAfterRemoveTest() {
        assertEquals(0, inventoryManager.getItemCount("Мяч"))
    }

    @Test
    fun removeNonItemTest() {
        assertEquals(false, inventoryManager.removeItem("Ракетка", 6))
    }

}