package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

class Dog(
) : Animal() {

    override fun makeSound(color: String) {
        println("${color}Bark\u001B[0m")
    }
}