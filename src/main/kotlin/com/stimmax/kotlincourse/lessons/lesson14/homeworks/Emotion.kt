package org.example.com.stimmax.kotlincourse.lessons.lesson14.homeworks

class Emotion(
    val type: String,
    val intensity: Int
) {

    fun express() {
        println("тип: $type, интенсивность: $intensity")
    }
}