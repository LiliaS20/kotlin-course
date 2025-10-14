package org.example.com.stimmax.kotlincourse.lessons.lesson11.homeworks

fun main() {
    println(fun4(listOf(1, 2, 3, 3)))
    println(fun5("null"))
    fun7(listOf(1, 2, 3))
    println(multiplyByTwo(5))
    println(isEven(5))
    println(isEven(4))
    printNumbersUntil(4)
    printNumbersUntil(0)
    println(findFirstNegative(listOf(1, 2, -3, 3, -5, 6)))
    processList(listOf("ddd", null, "dds"))
}

//Задачи на сигнатуру метода
//Не принимает аргументов и не возвращает значения.
fun fun1() {
    println("Привет")
}

//Принимает два целых числа и возвращает их сумму.
fun fun2(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

//Принимает строку и ничего не возвращает.
fun fun3(str: String) {
    println("Строка")
}

//Принимает список целых чисел и возвращает среднее значение типа Double.
fun fun4(list: List<Int>): Double {
    val countList = list.size
    var sum = 0.0
    for (l in list) {
        sum+=l
    }
    return sum / countList
}

//Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun fun5(str: String?): Int? {
    if (str != null) {
        return str.length
    } else {
        return null
    }
}

//Не принимает аргументов и возвращает nullable вещественное число.
fun fun6(): Double? {
    return 5.6
}

//Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun fun7(list: List<Int>?) {
    println(list)
}

//Принимает целое число и возвращает nullable строку.
fun fun8(arg: Int): String? {
    return arg.toString()
}

//Не принимает аргументов и возвращает список nullable строк.
fun fun9(): List<String?> {
    return listOf("строка 1", null, "строка 3")
}

//Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun fun10(str: String?, arg: Int?): Boolean {
    return true
}



//Задачи на написание кода
//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(arg: Int): Int {
    return arg * 2
}

//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное,
// и false в противном случае.
fun isEven(arg: Int): Boolean {
    return arg % 2 == 0
}

//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(arg: Int) {
    if (arg < 1) {
        return
    } else {
        for (i in 1..arg) {
            println(i)
        }
    }
}

//Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное
// число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(list: List<Int>): Int? {
    for (i in list) {
        if (i < 0) {
            return i
        }
    }
    return null
}

//Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и
// выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью
// return без возврата значения.
fun processList(list: List<String?>) {
    for (i in list) {
        if (i != null) {
            println(i)
        } else {
            return
        }
    }
}

