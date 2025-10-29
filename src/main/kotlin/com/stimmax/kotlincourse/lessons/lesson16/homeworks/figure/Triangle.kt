package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure

class Triangle(
    val height: Double,
    val footing: Double
): Shape() {

    override fun area(): Double {
        return 0.5 * height * footing
    }
}