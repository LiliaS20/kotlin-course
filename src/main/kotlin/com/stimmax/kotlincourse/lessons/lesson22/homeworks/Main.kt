package org.example.com.stimmax.kotlincourse.lessons.lesson22.homeworks

fun main() {

    // 1
    val agr1 = null
    try {
        agr1!!
    } catch (e: NullPointerException) {
        println("null значение")
    }

    // 2
    val list = listOf(4, 6, 9)
    try {
        println(list[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Нет значения с таким индексом")
    }

    // 3
    try {
        "string" as Int
    } catch (e: ClassCastException) {
        println("нельзя привести к такому типу")
    }

    // 4
    try {
        require(false)
    } catch (e: IllegalArgumentException) {
        println("недопустимый аргумент")
    }

    // 5
    try {
        "string".toDouble()
    } catch (e: NumberFormatException) {
        println("неверный числовой формат")
    }

    // 6
    try {
        check(false)
    } catch (e: IllegalStateException) {
        println("метод был вызван в неподходящем или незаконном состоянии приложения")
    }

    // 7
    try {
        (0..Long.MAX_VALUE).map { Long.MAX_VALUE }
    } catch (e: OutOfMemoryError) {
        println("закончилась память")
    }

    // 8
    try {
        fun8()
    } catch (e: StackOverflowError) {
        println("бесконечная рекурсия")
    }

    //Задание 10.
    fun10(null)
    fun10("WTF?")
    fun10(listOf(""))
    fun10(listOf(1, 2, 3))
    fun10(listOf(1, 2, "WTF?"))
    fun10(listOf(1, 2, "3"))

    //Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст.
// Выброси это исключение в main
    throw Exception11("Исключение")

    //Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий
// IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс
// IndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай
// выброс своего типа исключения.
    try {
        println(list[5])
    } catch (e: IndexOutOfBoundsException) {
        println("Ошибка")
        throw Exception12(e)
    }
}

fun fun8() {
    fun8()
}

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни
// набор действий с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения
// и выведи сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw,
// чтобы прекратить работу программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий
// что переданный аргумент фантастически хорош!
fun fun10(arg: Any?) {
    try {
        arg!!
        arg as List<*>
        arg[2]
        require(arg[2] is String)
        check((arg[2] as String).toInt() == 3)
    } catch (e: Throwable) {
        val result = when (e) {
            is NullPointerException -> "It is NullPointerException"
            is ClassCastException -> "It is ClassCastException"
            is IndexOutOfBoundsException -> "It is IndexOutOfBoundsException"
            is NumberFormatException -> "It is NumberFormatException"
            is IllegalArgumentException -> "It is IllegalArgumentException"
            is IllegalStateException -> "It is IllegalStateException"
            else -> "It is unknown exception"
        }
        println(result)
        throw e
    }
    println("We have a fantastically good argument!")
}