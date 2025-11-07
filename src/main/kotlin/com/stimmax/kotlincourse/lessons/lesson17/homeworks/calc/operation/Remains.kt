package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks.calc.operation

class Remains : Operation("%") {

    override fun executeOperation(str: String): String {
        return if (splitOper(str)[1] == 0.0) {
            "Делить на ноль нельзя"
        } else {
            (splitOper(str)[0] % splitOper(str)[1]).toString()
        }
    }
}