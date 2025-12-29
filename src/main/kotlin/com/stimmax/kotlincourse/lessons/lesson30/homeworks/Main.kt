package com.stimmax.kotlincourse.lessons.lesson30.homeworks

import org.example.com.stimmax.kotlincourse.lessons.lesson30.homeworks.InventoryManager

fun main() {

    val inventoryManager = InventoryManager(20)

    inventoryManager.apply {
        addItem("мячи", 10)
        println(getItemCount("мячи"))
        addItem("мячи", 3)
        println(getItemCount("мячи"))
        addItem("шары", 7)
        println(getItemCount("шары"))
        addItem("ракетки", 7)
        println(getItemCount("ракетки"))
        println(removeItem("мячи", 6))
        println(getItemCount("мячи"))
        println(removeItem("мячи", 10))
        println(getItemCount("мячи"))
        println(removeItem("ракетки", 6))
    }

//    inventoryManager.addItem("мячи", 10)
//    println(inventoryManager.getItemCount("мячи"))
//    inventoryManager.addItem("мячи", 5)
//    println(inventoryManager.getItemCount("мячи"))
//    inventoryManager.addItem("мячи", 5)
//    println(inventoryManager.getItemCount("мячи"))
}