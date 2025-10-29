package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.Colors

class Dog(
) : Animal() {

    override fun makeSound(color: String) {
        println("${color}Bark${Colors.RESET}")
    }
}