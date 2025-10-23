package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks

class Concert(
    val group: String,
    val place: String,
    val price: Double,
    val capacity: Int
) {

    private var ticketsSold: Int = 100

    fun getInfo() {
        val count = capacity - ticketsSold
        println("""
            Группа: $group
            Место: $place
            Стоимость билета: $price
            Количество свободных мест: $count
        """.trimIndent())
    }

    fun buyTicket(): Int {
        return ticketsSold++
    }
}