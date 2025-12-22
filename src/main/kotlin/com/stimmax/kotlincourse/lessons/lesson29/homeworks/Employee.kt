package org.example.com.stimmax.kotlincourse.lessons.lesson29.homeworks

//Задание 1
//
//Создай дата класс сотрудника компании Employee, содержащий:
//
//имя
//статус трудоустройства (булево)
//дата рождения (строка)
//должность CharacterTypes
//список подчинённых с типом Employee
//enum class CharacterTypes {
//   CTO,
//   UX_UI,
//   CRM, // Customer Relationship Manager
//   FRONTEND_DEV,
//   TEAM_LEAD,
//   BACKEND_DEV,
//   PM,
//   SYSADMIN,
//   QA
//}


data class Employee(
    val name: String,
    val status: Boolean,
    val birthDay: String,
    val position: CharacterTypes,
    val subordinatesList: List<Employee>
)

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    ANALYST,
    QA
}
