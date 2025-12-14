package org.example.com.stimmax.kotlincourse.lessons.lesson27.homeworks

//Задание 1
//Создай Enum со статусами прохождения теста (passed, broken, failed).
enum class TestStatus {
    PASSED,
    BROKEN,
    FAILED
}

//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
enum class RealEstate(
    val value: String
) {
    ROOM("Комната"),
    APARTMENT("Квартира"),
    HOUSE("Дом"),
    TOWNHOUSE("Таунхаус"),
    COTTAGE("Дача"),
    NON_RESIDENTAL_REAL_ESTATE("Нежилая недвижимость")
}

//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
enum class Planets(
    val namePlanet: String,
    val distance: Double,
    val weight: Double
) {
    MERCURY("Меркурий", 0.39, 3.302e23),
    VENUS("Венера", 0.72, 4.869e24),
    EARTH("Земля", 1.00, 5.974e24),
    MARS("Марс", 1.52, 6.419e23),
    JUPITER("Юпитер", 5.20, 1.899e27),
    SATURN("Сатурн", 9.54, 5.685e25),
    URANUS("Уран", 19.20, 8.685e25),
    NEPTUNE("Нептун", 30.06, 1.024e26);
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины
// названия enum.
fun printRealEstate() {
    println(RealEstate.entries.sortedBy { it.name.length })
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом
// прохождения теста в зависимости от того как выполнится принятая лямбда:
//
//если без исключений - PASSED
//если будет AssertionError - FAILED
//прочие исключения - BROKEN
fun f3(fnc: () -> Unit): TestStatus {
    return try {
        fnc()
        TestStatus.PASSED
    } catch (e: AssertionError) {
        TestStatus.FAILED
    } catch (e: Throwable) {
        TestStatus.BROKEN
    }
}

//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать
// булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет
// по какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или
// выкинуть исключение если список пустой.
fun f4(fnc: (Planets) -> Boolean): Planets {
    return Planets.entries.firstOrNull(fnc) ?: throw RuntimeException("Планеты нет")
}

fun main() {
    printRealEstate()
}