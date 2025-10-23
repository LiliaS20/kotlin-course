package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks

class Party(
    val location: String,
    val attendees: Int
) {

    fun details() {
        println(
            """
            Место: $location
            "Количество гостей: $attendees"
        """.trimIndent()
        )
    }

}