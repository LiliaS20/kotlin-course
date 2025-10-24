package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks

import org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves.Rack
import org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks.RackAndShelves.Shelf

fun main() {

    println("---1---")
    val info = Party("Москва", 234)
    info.details()

    println()
    println("---2---")
    val emotion = Emotion("радость", 55)
    emotion.express()

    println()
    println("---3---")
    Moon.showPhase(true, "Full Moon")

    println()
    println("---4---")
    val product = Product("молоко", 100.99, 23)
    println(product)

    println()
    println("---5---")
    val concert = Concert("The Beatles", "New York", 200.00, 20000)
    concert.getInfo()
    concert.buyTicket()
    concert.getInfo()

    println()
    println("---6---")
    val shelf1 = Shelf(21, mutableListOf("0_name1", "0_name2"))
    val shelf2 = Shelf(40, mutableListOf("1_name1", "1_name2", "1_name3", "1_name4"))
    val shelf3 = Shelf(29, mutableListOf("2_name1", "2_name2", "2_name3"))

    val rack = Rack(mutableListOf(shelf1, shelf2, shelf3), 5)
    println(rack.printContents())
    println("""
        
        удаленные предметы: ${rack.advancedRemoveShelf(1)}
        
    """.trimIndent())
    println(rack.printContents())

}

object Moon {
    fun showPhase(isVisible: Boolean, phase: String) {
        if (isVisible) {
            println("Фаза луны: $phase")
        } else {
            println("Луну не видно")
        }
    }
}
