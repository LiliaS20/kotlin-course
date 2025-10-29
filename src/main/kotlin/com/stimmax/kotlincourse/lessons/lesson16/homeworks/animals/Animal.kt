package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals

abstract class Animal {

    open fun makeSound(color: String) {
        println("${color}This animal makes no sound.\u001B[0m")
    }
}