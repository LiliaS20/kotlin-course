package org.example.com.stimmax.kotlincourse.lessons.lesson29.homeworks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun main() {

    //    Задание 2
    //Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк) и у каждого
    // было по группе сотрудников подходящего для его стека профиля.
    val emp1 = Employee("Иван", true, "23-12-2000",
        CharacterTypes.FRONTEND_DEV, listOf())
    val emp2 = Employee("Вадим", true, "23-12-2000",
        CharacterTypes.FRONTEND_DEV, listOf())
    val emp3 = Employee("Анна", true, "23-12-2000",
        CharacterTypes.BACKEND_DEV, listOf())
    val emp4 = Employee("Светлана", true, "23-12-2000",
        CharacterTypes.BACKEND_DEV, listOf())
    val emp5 = Employee("Сергей", true, "23-12-2000",
        CharacterTypes.QA, listOf())
    val emp6 = Employee("Ольга", true, "23-12-2000",
        CharacterTypes.ANALYST, listOf())

    val teamLeadFront = Employee("Андрей", true, "23-12-2000",
        CharacterTypes.FRONTEND_DEV, listOf(emp1, emp2))
    val teamLeadBack = Employee("Кирилл", true, "23-12-2000",
        CharacterTypes.BACKEND_DEV, listOf(emp3, emp4))

    val pm = Employee("Екатерина", true, "23-12-2000",
        CharacterTypes.PM, listOf(teamLeadFront, teamLeadBack, emp5, emp6))

    val crm = Employee("Виктор", true, "23-12-2000",
        CharacterTypes.CRM, listOf())

    val cto = Employee("Александр", true, "23-12-2000",
        CharacterTypes.CTO, listOf(pm, crm))

    f3(cto)
    f4()
}

//Задание 3
//Создай функцию в которой:
//сериализуй CTO в текст с настройкой prettyPrinting
//текст запиши в файл в корне проекта.
fun f3(employee: Employee) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(employee).also {
        File("workspace/cto.json").writeText(it)
    }
}

//Задание 4
//Создай функцию в которой:
//прочитай текст из файла
//десериализуй его в объект класса Employee
//распечатай в консоль
fun f4() {
    val gson = Gson()
    val json = File("workspace/cto.json").readText()
    gson.fromJson(json, Employee::class.java).also {
        println(it)
    }
}