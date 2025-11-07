package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation

class Multiplication : Operation("*") {

    override fun executeOperation(str: String): String {
        return (splitOper(str)[0] * splitOper(str)[1]).toString()
    }
}