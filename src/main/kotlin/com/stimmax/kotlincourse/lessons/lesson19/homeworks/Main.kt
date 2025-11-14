package org.example.com.stimmax.kotlincourse.lessons.lesson19.homeworks

//1. Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 != 0) {
        return list[list.size / 2]
    }
    return null
}

//2. Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового
// элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T>() {

    private val list = mutableListOf<T>()

    fun add(type: T): List<T> {
        list.add(type)
        return list.toList()
    }

    fun get(): List<T> {
        return list.toList()
    }
}

//3. Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//- элементов одного типа в элементы другого типа
//- списка элементов одного типа в список элементов другого типа
interface Mapper<T, U> {

    fun replace(element: T): U
    fun replaceList(list: List<T>): List<U>
}

//4. Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
// Метод преобразования списков с аналогичной механикой.
class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun replace(element: String): List<String> {
        return element.split(" ")
    }

    override fun replaceList(list: List<String>): List<List<String>> {
        return list.map { it.split(" ") }
    }
}

//5. Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает
// словарь, в котором ключ и значения поменялись местами.
fun <T, U> transposition(map: Map<T, U>): Map<U, T> {
    val map1 = mutableMapOf<U, T>()
    map.forEach { map1[it.value] = it.key }
    return map1
}

//6. Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом
// дженерика и возвращать булево значение.
interface Validator<T> {

    fun validate(type: T): Boolean
}

//7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку,
// что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator : Validator<String?> {

    override fun validate(type: String?): Boolean {
        return type?.isNotBlank() ?: false
    }
}

//8. Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
// Реализуй проверку, что число чётное.
class OddValidator: Validator<Int> {
    override fun validate(type: Int): Boolean {
        return type % 2 == 0
    }
}

//9. Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator
// типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0
class ListValidator<T : Number> : Validator<List<T?>> {

    override fun validate(type: List<T?>): Boolean {
        return type.all { it != null && it.toDouble() != 0.0 }
    }
}
