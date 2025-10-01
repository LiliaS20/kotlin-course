package org.example.com.stimmax.kotlincourse.lessons.lesson08.homeworks

fun main() {
    example1("Котлин лучший язык программирования")
}

fun example1(arg: String) {
    val result = when {
        arg.contains("невозможно") -> arg.replace("невозможно", "совершенно точно возможно, просто требует времени")
        arg.startsWith("Я не уверен") -> "$arg, но моя интуиция говорит об обратном"
        arg.contains("катастрофа") -> arg.replace("катастрофа", "интересное событие")
        arg.endsWith("без проблем") -> arg.replace("без проблем", "с парой интересных вызовов на пути")
        !arg.contains(" ") -> "Иногда $arg, но не всегда"
        else -> arg
    }
    println(result)
}

fun example2(arg: String) {
    val result = arg.split(" -> ")
    println(result.get(1).split(" ").get(0))
    println(result.get(1).split(" ").get(1))
}

fun example3(arg: String) {
    val result = "**** **** **** ${arg.substring(15)}"
    println(result)
}

fun example4(arg: String) {
    val result = arg.replace("@", " [at] ").replace(".", " [dot] ")
    println(result)
}

fun example5(arg: String) {
    val result = arg.split("/")
    println(result.get(result.size - 1))
}

fun example6(arg: String) {
    val result = arg.split(" ")
    var abbreviation: String = ""
    for (i in 0..result.size - 1) {
        abbreviation = abbreviation + result.get(i).elementAt(0)
    }
    println(abbreviation.uppercase())
}