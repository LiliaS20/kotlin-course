package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation

import kotlin.collections.map
import kotlin.text.toDouble

abstract class Operation(
    private val operation: String
) {
    fun check(str: String): Boolean {
        return str.contains(operation)
    }

    abstract fun executeOperation(str: String): String

    protected fun splitOper(str: String): List<Double> {
        val list = str.split(operation)
        return list.map { it.trim() }.map { it.toDouble()}
    }
}