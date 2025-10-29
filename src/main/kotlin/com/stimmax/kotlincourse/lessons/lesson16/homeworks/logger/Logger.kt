package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.logger

class Logger {

    fun log(message: String) {
        println("INFO | $message")
    }

    fun log(message: String, loggingLevel: String) {
        when (loggingLevel) {
            "WARNING" -> println("\u001b[33mWARNING | $message\u001b[0m")
            "ERROR" -> println("\u001b[37m\u001b[41mERROR | $message\u001b[0m")
            else -> println("DEBUG | $message")
        }
    }

    fun log(messageList: List<String>) {
        messageList.forEach { println("INFO | $it") }
    }

    fun log(exception: Exception) {
        println("ERROR | ${exception.message}")
    }
}