package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation

class Plus : Operation("+") {

    override fun executeOperation(str: String): String {
        return splitOper(str).sum().toString()
    }
}