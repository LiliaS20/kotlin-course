package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.printer

import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.Colors

class LaserPrinter : Printer() {

    override fun print(str: String) {
        val list = str.split(" ")
        list.forEach { println("\u001B[30m\u001B[47m$it\u001B[0m") }
    }
}