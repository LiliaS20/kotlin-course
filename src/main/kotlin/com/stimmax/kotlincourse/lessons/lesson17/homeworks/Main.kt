package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks

import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.Calculator

class Main {


}

fun main() {

    val gamblingMachine = GamblingMachine("черный", "модель", true)
    println(gamblingMachine.turnOn())
    println(gamblingMachine.getListOfGames())
    println(gamblingMachine.startGame("Игра 5"))
    println(gamblingMachine.payGameSession())
    println(gamblingMachine.startGame("Игра 5"))
    println(gamblingMachine.startGame("Игра 4"))
    println(gamblingMachine.collectCash("1234"))

    val calculator = Calculator(listOf())
    println(calculator.calc("4 - 6"))
    println(calculator.calc("4 + 6"))
    println(calculator.calc("4 ) 6"))
    println(calculator.calc("4 : 6"))
}