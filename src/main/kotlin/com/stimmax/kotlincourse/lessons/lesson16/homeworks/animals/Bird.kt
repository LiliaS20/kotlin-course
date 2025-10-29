package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.Colors

class Bird(
) : Animal() {

    override fun makeSound(color: String) {
        println("${color}Tweet${Colors.RESET}")
    }
}