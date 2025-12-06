package org.example.com.stimmax.kotlincourse.lessons.lesson24.homeworks

import kotlin.coroutines.Continuation

//1. Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число

fun fn1(arg: Boolean, fnc: () -> String): Int {
    return 4
}

//2. Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк
fun Int.fn2(fn: Int.(String) -> List<String>): List<String> {
    return fn("")
}

//3. Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик
fun <X, T> X.fn3(fn: X.() -> T): T {
    return fn()
}

//4. Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку
fun fn4(arg: String): () -> String {
    val fn: () -> String = { arg }
    return fn
}

//5. Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик
fun <X> X.fn5(): (String) -> X {
    val fn: (String) -> X = { this }
    return fn
}

//Задание 6.
object Colors {
   const val RESET = "\u001B[0m"
   const val RED = "\u001B[31m"
   const val GREEN = "\u001B[32m"
   const val YELLOW = "\u001B[33m"
   const val BLUE = "\u001B[34m"
   const val PURPLE = "\u001B[35m"
   const val CYAN = "\u001B[36m"
   const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
   return "$color$this${Colors.RESET}"
}

//Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает
// это же слово но уже "в цвете" через функцию colorize.
//Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.

//Напиши несколько функций обработки слов:
// = цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//  - начинается с большой буквы
//  - длина меньше трёх символов
//  - длина больше 6 символов
//  - длина кратна двум
//  - для всех прочих отдельный цвет.
// = цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Когда счётчик доходит до края
// списка слов - он обнуляется и начинается заново.
// = цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Счётчиком управляет функция,
// находящаяся в изменяемой переменной. Сначала это функция с инкрементом счётчика. Когда счётчик доходит до края
// списка цветов, нужно заменить функцию счётчика на функцию с декрементом. Когда счётчик доходит до нуля - заменить
// функцию счётчика на функцию с инкрементом и так далее.
//
//Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и
// передай в неё по очереди каждую из функций, проверь результат в консоли.
fun String.colorizeWords(fn: (String) -> String) {
    val result = this.split(" ").joinToString{
        it.colorize(fn(it))
    }
    println(result)
}

fun main() {

    val fn61 = { str: String ->
        when {
            str[0] == str[0].uppercase()[0] -> Colors.RED
            str.length < 3 -> Colors.PURPLE
            str.length > 6 -> Colors.YELLOW
            str.length % 2 == 0 -> Colors.BLUE
            else -> Colors.GREEN
        }
    }

    val colors = listOf(Colors.RED, Colors.BLUE, Colors.GREEN, Colors.PURPLE, Colors.YELLOW, Colors.CYAN, Colors.WHITE)

    var counter = 0

    val fn62 = { str: String ->
        if (counter >= colors.size) counter = 0
        colors[counter++]
    }

    var counterFunction = { counter++ }

    val fn63 = { str: String ->
        if (counter == colors.size - 1) {
            counterFunction = { counter-- }
        }
        if (counter < 0) {
            counter++
            counterFunction = { counter++ }
        }
        colors[counterFunction()]
    }

    val str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
            "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
            "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum " +
            "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui " +
            "officia deserunt mollit anim id est laborum."

    str.colorizeWords(fn61)
    str.colorizeWords(fn62)
    str.colorizeWords(fn63)
}