package org.example.com.stimmax.kaspressolearning.lessons.lesson04.homework

import kotlin.random.Random

class Person(private val name: String) {

    private val phrases = mutableListOf<String>()

    fun print() {
        println(phrases.joinToString(" "))
    }

    private fun selectPhrase(first: String, second: String): String {
        val random = Random.nextInt(0, 2)
        return if (random == 0) first else second
    }

    infix fun says(str: String): Person {
        phrases.add(str)
        return this
    }

    infix fun and(str: String): Person {
        check(phrases.isNotEmpty()) { "Нужно вызвать says" }
        phrases.add(str)
        return this
    }

    infix fun or(str: String): Person {
        check(phrases.isNotEmpty()) { "Нужно вызвать says" }
        phrases[phrases.lastIndex] = selectPhrase(str, phrases[phrases.lastIndex])
        return this
    }
}

fun main() {
    val andrew = Person("Andrew")
    andrew says "Hello" and "brothers." or "sisters." and "I believe" and "you" and "can do it" or "can't"
    andrew.print()
}