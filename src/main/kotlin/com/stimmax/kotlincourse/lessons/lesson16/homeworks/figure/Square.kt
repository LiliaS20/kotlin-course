package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure

class Square(
    val side: Double
): Shape() {

    override fun area(): Double {
        return side * side
    }
}