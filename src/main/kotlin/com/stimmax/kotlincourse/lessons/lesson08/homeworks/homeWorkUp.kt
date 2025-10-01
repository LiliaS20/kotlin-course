package org.example.com.stimmax.kotlincourse.lessons.lesson08.homeworks

fun main() {
    example8(260, 500)
}

fun example7(arg: String) {
    lateinit var letter: String
    var result: String = arg.elementAt(0).uppercase()
    for (i in 1..arg.length - 1) {
        if (arg[i - 1] == ' ') {
            letter = arg.elementAt(i).uppercase()
            result = "$result$letter"
        } else {
            result = "$result${arg.elementAt(i)}"
        }
    }
    println(result)
}

fun encrypt(arg: String) {
    lateinit var str: String
    var result = ""

    if (arg.length % 2 != 0) {
        str = "$arg "
    } else {
        str = arg
    }

    for (i in 0..str.length - 1 step 2) {
        result = "$result${str[i + 1]}${str[i]}"
    }
    println(result)
}

fun decrypt(arg: String) {
    var result = ""
    for (i in 0..arg.length - 1 step 2) {
        result = "$result${arg[i + 1]}${arg[i]}"
    }
    println(result.trim())
}

fun example8(arg1: Int, arg2: Int) {
    val countMax = (arg1 * arg2).toString().length + 2 // получаем максимальную длину числа при умножении
    val argMax = (if (arg1 > arg2) arg1 else arg2).toString().length // получаем максимальную длину аргумента

    for (i in 1..arg2) { // перечисляем в строку все перемножаемые числа
        if (i == 1) {
            print("%${countMax+argMax}s".format(i)) // отступ для первого числа
        } else {
            print("%${countMax}s".format(i))
        }
    }
    println()

    for (i in 1..arg1) { // запуск цикла для перемножения
        print("%${argMax}s".format(i)) // перечисляем в столбик все перемножаемые числа + отступ слева
        for (j in 1..arg2) {
            print("%${countMax}s".format(i * j))
        }
        println()
    }
}