package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

class Cat(
) : Animal() {

    override fun makeSound(color: String) {
        println("${color}Meow\u001B[0m")
    }
}