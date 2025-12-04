package org.example.com.stimmax.kotlincourse.lessons.lesson23.homeworks

import org.example.com.stimmax.kotlincourse.lessons.lesson11.homeworks.fun3
import kotlin.collections.toSet

fun main() {

    // ЗАДАЧА 1

    val fun11 = fun(list: List<Int>): Double {
        require(list.isNotEmpty())
        return list.filter { it % 2 == 0 }.average()
    }

    val fun12: (List<Int>) -> Double = { list ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }.average()
    }

    val fun13 = { list: List<Int> ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }.average()
    }

    val list1 = listOf(1, 2, 3, 4, 5, 6, 1, 3, 6, 3)
    println(fun1(list1))
    println(fun11(list1))
    println(fun12(list1))
    println(fun13(list1))


    // ЗАДАЧА 2

    val fun21 = fun(arg1: Int): Int {
        require(arg1 > 0)
        return arg1.toString().sumOf { it.digitToInt() }
    }

    val fun22: (Int) -> Int = { arg1 ->
        require(arg1 > 0)
        arg1.toString().sumOf { it.digitToInt() }
    }

    val fun23 = { arg1: Int ->
        require(arg1 > 0)
        arg1.toString().sumOf { it.digitToInt() }
    }

    println(fun2(123))
    println(fun21(123))
    println(fun22(123))
    println(fun23(123))


    // ЗАДАЧА 3

    val fun31 = fun List<Int>.(): Set<Int> {
        return toSet().associateWith { element -> this.count { it == element } }.filter { it.value > 1 }
            .keys
    }

    val fun32: List<Int>.() -> Set<Int> = {
        toSet().associateWith { element -> this.count { it == element } }.filter { it.value > 1 }
            .keys
    }

    println(list1.fun3())
    println(list1.fun31())
    println(list1.fun32())

}

fun fun1(list: List<Int>): Double {
    require(list.isNotEmpty())
    return list.filter { it % 2 == 0 }.average()
}

fun fun2(arg1: Int): Int {
    require(arg1 > 0)
    return arg1.toString().sumOf { it.digitToInt() }
}

fun List<Int>.fun3(): Set<Int> {
    return toSet().associateWith { element -> this.count { it == element } }.filter { it.value > 1 }
        .keys
}