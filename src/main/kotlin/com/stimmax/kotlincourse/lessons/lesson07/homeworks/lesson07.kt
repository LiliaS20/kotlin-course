package org.example.com.stimmax.kotlincourse.lessons.lesson07.homeworks

fun main() {

    example25()

}

// 1. Используя вложенный цикл реализовать таблицу умножения, как на картинке.
fun example21() {
    for (i in 1..10) {
        for (j in 1..10) {
            print(i * j)
            print(" ")
        }
        println()
    }
}

// 2. Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.
fun example22(arg: Int) {
    var sum: Int = 0
    for (i in 1..arg) {
        sum+=i
    }
    println(sum)
}

// 3. Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun example23(arg: Int) {
    var sum: Int = 1
    for (i in 1..arg) {
        sum*=i
    }
    println(sum)
}

// 4. Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun example24(arg: Int) {
    var sum: Int = 0
    var counter: Int = 0
    while (counter++ < arg) {
        if (counter % 2 == 0) {
            sum += counter
        }
    }
    println(sum)
}

// 5. Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3
// из символов *.
fun example25() {
    var arg1: Int = 0
    var arg2: Int = 0
    while (arg2++ < 5) {
        while (arg1++ < 3) {
            print(arg2)
            print(" ")
        }
        arg1 = 0
        println()
    }
}

// 6. Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun example26(arg: Int) {
    var sum1: Int = 0
    var sum2: Int = 0
    for (i in 1..arg) {
        if (i % 2 == 0) {
            sum1+=i
        } else {
            sum2+=i
        }
    }
    println("Сумма четных: " + sum1)
    println("Сумма нечетных: " + sum2)
}