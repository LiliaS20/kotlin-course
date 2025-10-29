package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

class Bird(
) : Animal() {

    override fun makeSound(color: String) {
        println("${color}Tweet\u001B[0m")
    }
}