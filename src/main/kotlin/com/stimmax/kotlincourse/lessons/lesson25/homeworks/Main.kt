package org.example.com.stimmax.kotlincourse.lessons.lesson25.homeworks

import com.sun.security.auth.module.UnixSystem

//Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах. Для измерения времени используйте
// System.currentTimeMillis() до и после выполнения переданной функции.
fun timeTracker(fn: () -> Any): Long {
    val fnStart = System.currentTimeMillis()
    fn()
    return System.currentTimeMillis() - fnStart
}

//Давайте создадим два класса, которые будут использоваться в заданиях для демонстрации работы scope функций
// с преобразованием объектов и инициализацией или обновлением полей. Классы будут представлять собой Person
// и Employee, где Employee может быть создан на основе данных класса Person.
class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

//Задание 2: Использование apply для инициализации объекта Employee
//Создайте объект Employee и используйте apply для инициализации его полей email и department.
val emp1 = Employee("Анна", 20, "менеджер").apply {
    email = "annaA@gmail.com"
    department = "Юр лица"
}

//Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом,
// отформатированном виде. Используй with для создания контекста Person и возможности использовать поля объекта
// напрямую без обращения к переменной.
//Создайте объект Person и используйте also для добавления почты и печати данных в консоль с помощью метода который
// только что создали.
fun fn3(person: Person) {
    with(person) {
        println(
            """
           Имя: $name
           Возраст: $age
           Почта: $email
       """.trimIndent()
        )
    }
}

fun main() {

    val person3 = Person("Петр", 42).also {
        it.email = "petrP@gmail.com"
        fn3(it)
    }
}

//Задание 4: Использование with для преобразование Person в Employee
//Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав
// дополнительно должность. Возвращаемым значением должен быть новый объект Employee.
val person4 = Person("Иван", 28).apply {
    email = "ivanI@gmail.com"
}
val emp4 = with(person4) {
    Employee(name, age, "менеджер").also {
        it.email = email
        it.department = "Юр лица"
    }
}

//Задание 5: Использование run для преобразования и инициализации Employee
//Перепиши предыдущую задачу на использование run вместо with.
val emp5 = person4.run {
    Employee(name, age, "менеджер").also {
        it.email = email
        it.department = "Юр лица"
    }
}

//Задание 6: Использование let для безопасного преобразования Person в Employee
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null. В функции используйте
// функцию let для создания Employee, только если объект Person не null. В противном случае возвращается null
fun Person?.toEmployee(position: String, depart: String): Employee? {
    return this?.let {
        Employee(it.name, it.age, position).apply {
            email = it.email
            department = depart
        }
    }
}
