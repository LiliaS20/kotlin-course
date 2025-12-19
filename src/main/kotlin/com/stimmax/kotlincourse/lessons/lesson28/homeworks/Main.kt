package org.example.com.stimmax.kotlincourse.lessons.lesson28.homeworks

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

fun main() {

//1. Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    val instant = Instant.now()
    println(instant)

//2. Создай дату своего дня рождения.
    val birthday = LocalDate.of(2000, 6, 4)
    println(birthday)

//3. Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val dayNow = LocalDate.now()
    println(Period.between(birthday, dayNow).years)


//5. Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше. Не используй
// в них метод now()
    val localT = LocalTime.now()
    val localD = LocalDate.now()
    val localDT = LocalDateTime.now()
    val zonedDT = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
    val offsetDT = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+03:00"))

    f4(localT)
    f4(localD)
    f4(localDT)
    f4(zonedDT)
    f4(offsetDT)


// 6.
    LocalDate.of(2003, 2, 25).identifyGeneration()
    LocalDate.of(1946, 1, 1).identifyGeneration()

//7. Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату
// в месяц и день.
    val d1 = LocalDate.of(2023, 2, 25)
    val d2 = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("MM-dd")

//8. Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println(d1.plusDays(10).format(formatter))

//9. Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
    println(d2.plusDays(10).format(formatter))
}

//4. Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит
// ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени. В форматированном
// значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте.
// Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный форматированием
// и с форматами из ISO коллекции.

fun f4(temporal: Temporal) {
    when (temporal) {
        is LocalDate -> "dd-MM-yyyy"
        is LocalTime -> "HH:mm:SS"
        is LocalDateTime -> "dd-MM-yyyy HH:mm:SS"
        is ZonedDateTime -> "dd-MM-YYYY HH:mm:ss z"
        is OffsetDateTime -> "dd-MM-YYYY HH:mm:ss ZZZ"
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }.let {
        DateTimeFormatter.ofPattern(it).format(temporal)
    }.also {
        println(it)
    }
}

//6. Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую, к какому
// поколению принадлежит человек родившийся в эту дату: "Бумер" для тех, кто родился с 1946 по 1964 год включительно,
// и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один из этих
// диапазонов, функция должна печатать "Не определено". Для сравнения дат используй методы isAfter(otherDate) и
// isBefore(otherDate) или проверку вхождения в диапазон. Объекты с эталонными датами вынеси в приватные поля файла
// с методом identifyGeneration.

private val boomerFrom = LocalDate.of(1946, 1, 1)
private val boomerTo = LocalDate.of(1964, 12, 31)
private val zoomerFrom = LocalDate.of(1997, 1, 1)
private val zoomerTo = LocalDate.of(2012, 12, 31)

fun LocalDate.identifyGeneration() {
    when {
        this.isAfter(boomerFrom.minusDays(1))
                && this.isBefore(boomerTo.plusDays(1)) -> println("Бумер")

        this.isAfter(zoomerFrom.minusDays(1))
                && this.isBefore(zoomerTo.plusDays(1)) -> println("Зумер")

        else -> println("Не определено")
    }
}
