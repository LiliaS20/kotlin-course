package org.example.com.stimmax.kotlincourse.lessons.lesson20.homeworks

import kotlin.math.absoluteValue

fun main() {

    println("qwerty".encrypt(5))
    println("qwerty".encrypt(5).decrypt(5))

    val mdd = "Kotlin"
    mdd.fun5(listOf("Иван", "Анна", "Сергей", "Екатерина", "Петр"))
}

//Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел -
// первое и последнее. Если массив был пуст то вернуть пару из null значений.
fun Array<Int?>.fun1(): Pair<Int?, Int?> {
    return if (isEmpty()) {
        null to null
    } else {
        this[0] to this[size - 1]
    }
}

//Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true
// и по убыванию, если false (используем функции sort() и sortDescending()
fun <T : Comparable<T>> MutableList<T>.fun2(arg1: Boolean): List<T> {
    if (arg1) {
        sort()
    } else {
        sortDescending()
    }
    return this.toList()
}

//Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого
// индекса нет - значением будет null
fun <T> Map<T, List<T>>?.fun3(arg1: Int): Map<String, T?>? {
    return this?.mapKeys { it.key.toString() }
        ?.mapValues { it.value.getOrNull(arg1) }
}

//Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от
// эталонного не более допустимого значения. Метод принимает два параметра: other — число для сравнения и
// deviation — максимально допустимое отклонение. Метод должен возвращать true, если разница между текущим
// числом и числом для сравнения не превышает заданное отклонение. Протестируйте функцию на разных типах чисел.
// Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.
fun Number.within(other: Number, deviation: Number): Boolean {
    return (toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()
}

//Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый
// символ исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число
// позиций назад. Оба метода принимают один параметр base типа Int, который определяет величину сдвига.
// Протестируйте вашу реализацию, убедившись, что после шифрования и последующей расшифровки строка возвращается
// к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
fun String.encrypt(base: Int): String {
    return this.map { it + base }.joinToString("")
}

fun String.decrypt(base: Int): String {
    return this.map { it - base }.joinToString("")
}

//Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что
// слово только одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список
// имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора
// и букву под ним
fun String.fun5(authors: List<String>) {
    var counter = 0
    for (index in 0 until this.length) {
        println(authors[counter++])
        println(this[index].uppercase())
        println()
        if (counter >= this.length - 1) {
            counter = 0
        }
    }
}

