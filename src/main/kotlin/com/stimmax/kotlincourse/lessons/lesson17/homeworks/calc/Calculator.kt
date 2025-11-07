package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc

import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Operation
import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Minus
import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Plus
import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Multiplication
import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Division
import org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation.Remains

class Calculator(private val customOperations: List<Operation>) {
    private val operations = listOf(
        Plus(),
        Minus(),
        Multiplication(),
        Division(),
        Remains()
    ) + customOperations

    fun calc(str: String): String {
        val operation = operations.firstOrNull { it.check(str) }
        if (operation == null) {
            return "Unsupported operator in the expression '$str'"
        }
        return operation.executeOperation(str)
    }
}