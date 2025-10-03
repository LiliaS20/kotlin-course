package org.example.com.stimmax.kotlincourse.lessons.lesson08.homeworks

fun main() {
    example8(34, 55)
}

//Напишите метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с
// заглавной буквы, а все остальные - строчные. Используй перебор, анализ символов и замену букв на заглавную
// с помощью метода uppercase() для конкретной буквы.
fun example7(arg: String) {
    lateinit var letter: String
    var result: String = arg.elementAt(0).uppercase()
    for (i in 1 until arg.length) {
        if (arg[i - 1] == ' ') {
            letter = arg.elementAt(i).uppercase()
            result = "$result$letter"
        } else {
            result = "$result${arg.elementAt(i)}"
        }
    }
    println(result)
}

// Напишите шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой:
// Kotlin шифруется в oKltni. Дешифровка выполняется аналогично.
//Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования. Таким образом все шифрованные
// сообщения будут с чётной длинной. Должно получиться два публичных метода: encrypt() и decrypt() которые
// принимают строку и печатают результат в консоль.
fun encrypt(arg: String) {
    lateinit var str: String
    var result = ""

    if (arg.length % 2 != 0) {
        str = "$arg "
    } else {
        str = arg
    }

    for (i in 0 until str.length step 2) {
        result = "$result${str[i + 1]}${str[i]}"
    }
    println(result)
}

fun decrypt(arg: String) {
    var result = ""
    for (i in 0 until arg.length step 2) {
        result = "$result${arg[i + 1]}${arg[i]}"
    }
    println(result.trim())
}

//Напишите функцию, которая принимает два числа и выводит таблицу умножения, у которой в заголовках столбцов и
//строк находятся перемножаемые числа, а в перекрестии заголовка и столбца - результат перемножения. Важно:
// каждый столбец должен быть выровнен по правому краю с помощью шаблона с форматированием строк.
// Размер форматирования каждой строки нужно вычислять динамически для каждого столбца.
fun example8(arg1: Int, arg2: Int) {
    val countMax = (arg1 * arg2).toString().length + 2 // получаем максимальную длину числа при умножении
    val argMax = (if (arg1 > arg2) arg1 else arg2).toString().length // получаем максимальную длину аргумента

    for (i in 1..arg2) { // перечисляем в строку все перемножаемые числа
        if (i == 1) {
            print("%${countMax+argMax}s".format(i)) // отступ для первого числа
        } else {
            print("%${countMax}s".format(i))
        }
    }
    println()

    for (i in 1..arg1) { // запуск цикла для перемножения
        print("%${argMax}s".format(i)) // перечисляем в столбик все перемножаемые числа + отступ слева
        for (j in 1..arg2) {
            print("%${countMax}s".format(i * j))
        }
        println()
    }
}