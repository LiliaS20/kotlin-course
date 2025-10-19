package org.example.com.stimmax.kotlincourse.lessons.lesson13.homeworks

fun main() {

//1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах.
// Определите среднее время выполнения теста.
    val map1 = mapOf("Тест 1" to 5.33, "Тест 2" to 4.32, "Тест 3" to 3.21)
    println("%.2f".format(map1.values.average()))

//2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов,
// а значения - строка с метаданными. Выведите список всех тестовых методов.
    val map2 = mapOf("name1" to "Int, String", "name2" to "String, Double", "name3" to "Double, Int")
    println(map2.keys)

//3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val map3 = mutableMapOf("Тест 1" to 5.33, "Тест 2" to 4.32, "Тест 3" to 3.21)
    map3["Имя 4"] = 1.22
    println(map3)

//4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат
// из passed, failed, skipped).
    val map4 = mapOf("Тест 1" to "passed", "Тест 2" to "failed", "Тест 3" to "skipped", "Тест 4" to "passed",
        "Тест 5" to "passed", "Тест 6" to "failed")
    println(map4.count { it.value == "passed" })

//5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название,
// значение - статус исправления).
    val map5 = mutableMapOf("Баг1" to "В очереди", "Баг2" to "Тестирование", "Баг3" to "Исправлен")
    map5.remove("Баг3", "Исправлен")
    println(map5)

//6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа),
// выведите сообщение о странице и статусе её проверки.
    val map6 = mapOf("Страница1" to 200, "Страница2" to 404, "Страница3" to 200)
    println(map6.entries)

//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val map7 = mapOf("Сервис1" to 1.22, "Сервис2" to 0.43, "Сервис3" to 0.77, "Страница4" to 2.11)
    println(map7.filter { it.value < 1.00 })

//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
// Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val map8 = mapOf("endpoint1" to "200", "endpoint2" to "404", "endpoint3" to "200")
    println(map8.getOrElse("endpoint4") { "Не протестирован" })

//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации,
// значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val map9 = mapOf("operatingSystem" to " Android 12", "device" to "Samsung Galaxy S21", "browserType" to "Yandex")
    println(map9["browserType"])

//10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val map10 = mapOf("01.02.2025" to "1.1.1", "06.03.2025" to "1.1.2", "21.06.2025" to "1.1.3")
    val map101 = map10.plus("26.09.2025" to "1.1.4")
    println(map101)

//11. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства,
// значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val map11 = mapOf("Samsung 1" to "settings 1", "Samsung 2" to "settings 2", "Samsung 3" to "settings 3")
    println(map11.getOrDefault("Samsung 4", "default settings"))

//12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки)
// определенный код ошибки.
    val map12 = mapOf("400" to "Bad Request", "401" to "Unauthorized", "403" to "Forbidden", "404" to "Not Found")
    println(map12.containsKey("404"))

//13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
// а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь,
// оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в
// ключе содержится требуемая версия.
    val map13 = mutableMapOf("101_1.1.1" to "Passed", "102_1.1.2" to "Failed", "103_1.1.3" to "Passed",
        "104_1.1.1" to "Skipped", "105_1.1.2" to "Failed", "106_1.1.3" to "Passed", "107_1.1.1" to "Passed")
    println(map13.filter { it.key.contains("1.1.1")} )

//14. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты
// их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val map14 = mapOf("Модуль 1" to "Passed", "Модуль 2" to "Skipped", "Модуль 3" to "Failed", "Модуль 4" to "Passed",
        "Модуль 5" to "Failed", "Модуль 6" to "Skipped", "Модуль 7" to "Passed", "Модуль 8" to "Passed")
    println(map14.filter { it.value == "Failed" }.keys)

//15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val map15 = mutableMapOf("Samsung 4" to "settings 4", "Samsung 5" to "settings 5")
    map15.putAll(map11)
    println(map15)

//16. Объедините два неизменяемых словаря с данными о багах.
    val map161 = mapOf("Баг1" to "В очереди", "Баг2" to "Тестирование", "Баг3" to "Исправлен")
    val map162 = mapOf("Баг4" to "В очереди", "Баг5" to "Тестирование", "Баг6" to "Исправлен")
    val map163 = map161 + map162
    println(map163)

//17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val map17 = mutableMapOf("Прогон 1" to 23.11, "Прогон 2" to 23.11, "Прогон 3" to 23.11)
    map17.remove(map17.keys.last())
    println(map17)

//18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены
// (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val map18 = mutableMapOf("Тест 1" to "passed", "Тест 2" to "failed", "Тест 3" to "skipped", "Тест 4" to "passed",
        "Тест 5" to "passed", "Тест 6" to "skipped")
    val map181 = map18.filterValues { it != "skipped" }
    println(map181)

//19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val map191 = mapOf("operatingSystem" to " Android 12", "device" to "Samsung Galaxy S21",
        "browserType" to "Yandex")
    println(map9["browserType"])
    val map19 = map191.filterKeys { it != "device" && it != "browserType"}
    println(map19)

//20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор
// теста, значение — результат) в список строк формата "Test ID: результат".
    val map20 = mapOf("Тест 1" to "passed", "Тест 2" to "failed", "Тест 3" to "skipped", "Тест 4" to "passed",
        "Тест 5" to "passed", "Тест 6" to "failed")
    val list: MutableList<String> = mutableListOf()
    map20.forEach { (id, result) ->
        list.add("$id: $result")
    }
    println(list)

//21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val map21 = mutableMapOf("Прогон 1" to 23.11, "Прогон 2" to 23.11, "Прогон 3" to 23.11)
    val map211 = map21.toMap()

//22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив
// идентификаторы тестов на их строковый аналог (например через toString()).
    val map22 = mapOf(111 to "passed", 112 to "failed", 113 to "skipped", 114 to "passed",
        115 to "passed", 116 to "failed")
    val map221: MutableMap<String, String> = mutableMapOf()
    map22.forEach { (id, result) ->
        map221[id.toString()] = result
    }
    println(map221)

//23. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия,
// значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые
// условия тестирования.
    val map23 = mutableMapOf("Версия 1" to 34.13, "Версия 2" to 54.32, "Версия 3" to 32.43, "Версия 4" to 29.56)
    val map231 = map23.mapValues {
        map -> "%.2f".format(map.value * 1.1)
    }
    println(map231)

//24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val map24= mutableMapOf<Int, String>()
    println(map24.isEmpty())

//25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val map25= mutableMapOf<String, String>("Прогон 1" to "passed")
    println(map25.isNotEmpty())

//26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val map26 = mapOf("Тест 1" to "passed", "Тест 2" to "failed", "Тест 3" to "skipped", "Тест 4" to "passed",
        "Тест 5" to "passed", "Тест 6" to "failed")
    println(map26.all { it.value == "passed" })

//27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    println(map26.any { it.value == "failed" })

//28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не
// прошли успешно и содержат в названии “optional”.
    val map28 = mapOf("Тест 1 optional" to "passed", "Тест 2" to "failed", "Тест 3 optional" to "skipped", "Тест 4" to "passed",
        "Тест 5" to "passed", "Тест 6 optional" to "failed")
    println(map28.minus(map28.filter { it.key.contains("optional") && it.value != "passed"}.keys))

}