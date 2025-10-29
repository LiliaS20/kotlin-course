package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.printer

class InkjetPrinter: Printer() {

    private val map = listOf(
        "\u001B[30m" to "\u001B[47m", // черный на белом
        "\u001B[35m" to "\u001B[41m", // розовый на красном
        "\u001B[40m" to "\u001B[42m" //
    )

    override fun print(str: String) {
        val list = str.split(" ")
        var indexMap = 0
        for (i in list.indices) {
            if (indexMap < map.size) {
                println("${map[indexMap].first}${map[indexMap].second}${list[i]}\u001B[0m")
                indexMap++
            } else {
                indexMap = 0
            }
        }
    }
}