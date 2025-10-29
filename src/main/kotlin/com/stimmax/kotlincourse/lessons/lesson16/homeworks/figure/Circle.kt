package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure

class Circle(
    val radius: Double
): Shape() {

    override fun area(): Double {
        return radius * 2 * 3.14
    }
}