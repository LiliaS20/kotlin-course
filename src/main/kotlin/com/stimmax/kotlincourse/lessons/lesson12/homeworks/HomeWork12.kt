package org.example.com.stimmax.kotlincourse.lessons.lesson12.homeworks

fun main() {

    val list1 = listOf(1, 2, 3, 4, 5, 6)
    println("Задачи на приведение коллекции к значению")
//Проверить, что размер коллекции больше 5 элементов.
    println(list1.size)

//Проверить, что коллекция пустая
    println(list1.isEmpty())

//Проверить, что коллекция не пустая
    println(list1.isNotEmpty())

//Взять элемент по индексу или создать значение если индекса не существует
    println(list1.getOrElse(7) { 5 })

//Собрать коллекцию в строку
    println(list1.joinToString(""))

//Посчитать сумму всех значений
    println(list1.sum())

//Посчитать среднее
    println(list1.average())

//Взять максимальное число
    println(list1.maxOrNull())

//Взять минимальное число
    println(list1.minOrNull())

//Взять первое число или null
    println(list1.firstOrNull())

//Проверить что коллекция содержит элемент
    println(list1.contains(4))


    println("Задачи на обработку коллекций")
    val list2 = listOf(4, 56, 65, 27, 10, 19, 30, 54, 22, 43, 6)
//Отфильтровать коллекцию по диапазону 18-30
    println(list2.filter { it in 18..30 })

//Выбрать числа, которые не делятся на 2 и 3 одновременно
    println(list2.filterNot { it % 2 == 0 }.filterNot { it % 3 == 0 })

//Очистить текстовую коллекцию от null элементов
    val listString1 = listOf("Строка 1", null, null, "Строка 4")
    println(listString1.filter { it != null })

//Преобразовать текстовую коллекцию в коллекцию длин слов
    val listString2 = listOf("Строка 1", "Строк", "Строка ", "Строка")
    println(listString2.map { it.length })

//Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    println(listString2.associate { it.reversed() to it.length })

//Отсортировать список в алфавитном порядке
    val listString3 = listOf("Зима", "Весна", "Лето", "Осень", "Заяц", "Олень", "Лиса")
    println(listString3.sorted())

//Взять первые 3 элемента списка
    println(listString3.take(3))


//Распечатать квадраты элементов списка
    println(list1.map { it * it })

//Группировать список по первой букве слов
    println(listString3.groupBy { it[0] })

//Очистить список от дублей
    val list3 = listOf(1, 5, 1, 4, 5, 3, 3)
    println(list3.distinct())

//Отсортировать список по убыванию
    println(list3.sortedDescending())

//Взять последние 3 элемента списка
    println(list3.takeLast(3))

    println("Задача 24")
    println(fun24(listOf()))
    println(fun24(listOf(1, 2, 3)))
    println(fun24(listOf(0, 1, 2, 6, 7, 7)))
    println(fun24(listOf(2000, 3000, 4000, 5000, 45, 55)))
    println(fun24(listOf(5, 10, 15, 5, 10, 15)))
    println(fun24(listOf(100, 200, 300, 400, 500, 600, 70)))
    println(fun24(listOf(-30, -45, -12, -56, -11, -23)))
    println(fun24(listOf(1000, 1003, 1001, 1004, 1989, 1844)))
    println(fun24(listOf(23, 14, 5, 3, 67)))
    println(fun24(listOf(2, 3, 4, 6, 6, 7)))

    println("Задача 25")
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра",
        "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка",
        "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка",
        "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка",
        "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы",
        "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда",
        "Настольная лампа", "торшер", "Этажерка"
    )
    println(fun26(list))

    println("Задача 26")
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(fun25(grades))

    println("Задача 27")
    println(fun27(list))

    println("Задача 28")
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(fun28(numbers))

    println("Задача 29")
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println(fun29(ages, 18))
}

fun fun24(list: List<Int>): String {
    return when {
        list.isEmpty() -> "Пусто"
        list.size < 5 -> "Короткая"
        list.firstOrNull() == 0 -> "Стартовая"
        list.sum() > 10000 -> "Массивная"
        list.average().toInt() == 10 -> "Сбалансированная"
        list.joinToString("").length == 20 -> "Клейкая"
        (list.maxOrNull() ?: Int.MAX_VALUE) < -10 -> "Отрицательная"
        (list.minOrNull() ?: Int.MIN_VALUE) > 1000 -> "Положительная"
        list.contains(3) && list.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}

fun fun25(list: List<Int>): List<Int> {
    return list.filter { it >= 60 }.sorted().take(3)
}

fun fun26(list: List<String>): Map<Char, List<String>> {
    return list.sorted().map { it.lowercase() }.groupBy { it[0] }
}

fun fun27(list: List<String>): String {
    val format = "%.2f"
    return format.format(list.map { it.length }.average())
}

fun fun28(list: List<Int>): Map<String, List<Int>> {
    return list.distinct().sortedDescending().groupBy { if (it % 2 == 0) "четные" else "нечетные" }
}

fun fun29(list: List<Int?>, arg: Int): Int? {
    return list.filterNotNull().firstOrNull { it >= arg }
}

