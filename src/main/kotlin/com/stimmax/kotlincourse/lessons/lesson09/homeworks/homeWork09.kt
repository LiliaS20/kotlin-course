package org.example.com.stimmax.kotlincourse.lessons.lesson09.homeworks

fun main() {
//    ---------------МАССИВЫ------------------
    println("----------МАССИВЫ--------------")
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val array1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

//Создайте пустой массив строк размером 10 элементов.
    val array2 = Array(5) { "" }

//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val doubles: DoubleArray = doubleArrayOf(0.0, 2.2, 4.4, 6.6, 8.8)

//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение,
// равное его индексу, умноженному на 3.
    val array3 = arrayOfNulls<Int>(5)
    for (i in 0 until array3.size) {
        array3[i] = (i * 3)
    }
    println(array3.joinToString())

//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val array4 = Array(3) {"fff"; null; "ffd"}

//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val array51: Array<Int> = arrayOf(1, 2, 3)
    val array52 = arrayOfNulls<Int>(array51.size)
    for (i in 0 until array51.size) {
        array52[i] = array51[i]
    }
    println(array52.joinToString())

//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
    val array61 = arrayOf(1, 2, 3, 4, 5)
    val array62 = arrayOf(10, 9, 8, 7, 6)
    val array63 = arrayOfNulls<Int>(array61.size)
    for (i in 0 until array61.size) {
        array63[i] = array62[i] - array61[i]
    }
    println(array63.joinToString())

//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве,
// возвращаем -1. Реши задачу через цикл while.
    val array7 = arrayOf(5, 2, 4, 6, 8, 10)
    var counter = 0
    var arg = -1

    while (counter < array7.size) {
        if (array7[counter] == 5) {
            arg = counter
        } else {
            arg
        }
        counter++
    }
    println(arg)

//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val array8: Array<Int> = arrayOf(1, 3, 4, 6, 7, 8, 10)
    for (i in array8) {
        if (i % 2 == 0) {
            println("$i - четное")
        } else {
            println("$i - нечетное")
        }
    }

//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве
// элемент, в котором принятая строка является подстрокой (метод contains()). Верни найденный элемент из функции в виде
// строки.
    val array9 = arrayOf("зима", "весна", "лето", "осень")
    example1(array9, "е")



//    ----------------СПИСКИ--------------------
    println("----------СПИСКИ---------------")
//Создайте пустой неизменяемый список целых чисел.
    val list1: List<Int> = listOf(1, 2, 3, 4)

//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val list2: List<String> = listOf("Hello", "World", "Kotlin")

//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val list3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val list4: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    list4.add(6)
    list4.add(7)
    list4.add(8)
    println(list3.joinToString())

//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val list5: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    list5.removeAt(1)
    println(list5.joinToString())

//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val list6: List<Int> = listOf(1, 2, 3, 4, 5)
    for (i in list6) {
        println(i)
    }

//Создайте список строк и получите из него второй элемент, используя его индекс.
    val list7: List<String> = listOf("Hello", "World", "Kotlin")
    println(list7[0])

//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например,
// замените элемент на позиции 2 на новое значение).
    val list8: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    list8[2] = 7
    println(list8.joinToString())

//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
    val list81: List<String> = listOf("Hello", "World", "Kotlin")
    val list82: List<String> = listOf("Hello", "World", "Kotlin")
    val list83: MutableList<String> = mutableListOf()
    for (i in list81) {
        list83.add(i)
    }
    for (i in list82) {
        list83.add(i)
    }
    println(list83.joinToString())

//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val list9: List<Int> = listOf(54, 64, 3, -27, 8, 35)
    var min = Int.MIN_VALUE
    var max = Int.MAX_VALUE
    for (i in list9) {
        if (i > min) {
            min = i
        } else if (i < max) {
            max = i
        }
    }
    println("$max - максимальное")
    println("$min - минимальное")

//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val list10: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val list11: MutableList<Int> = mutableListOf()
    for (i in list10) {
        if (i % 2 == 0) {
            list11.add(i)
        }
    }
    println(list11.joinToString())



//    ----------------МНОЖЕСТВА--------------------
    println("----------МНОЖЕСТВА---------------")
//Создайте пустое неизменяемое множество целых чисел.
    val set1: Set<Int> = emptySet()

//Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val set2: Set<Int> = setOf(1, 2, 3)

//Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например,
// "Kotlin", "Java", "Scala").
    val set3: Set<String> = setOf("Kotlin", "Java", "Scala")

//Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val set4: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    set4.add("Swift")
    set4.add("Go")

//Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    set4.remove("Scala")

//Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val set5: Set<Int> = setOf(1, 2, 3, 4, 5)
    for (i in set5) {
        println(i)
    }

//Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве
// указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    example2(setOf("Kotlin", "Java", "Scala"), "Java")

//Создайте два множества строк и объедините их в одно новое множество, содержащее все уникальные
// элементы обоих множеств. Реши задачу с помощью циклов.
    val set61: Set<String> = setOf("Kotlin", "Java", "Swift")
    val set62: Set<String> = setOf("Go", "Swift", "Scala")
    val set63: MutableSet<String> = mutableSetOf()
    for (i in set61) {
        set63.add(i)
    }
    for (i in set62) {
        set63.add(i)
    }
    println(set63.joinToString())

//Создайте два множества целых чисел и найдите их пересечение (общие элементы). Реши задачу через вложенные циклы.
    val set71: Set<Int> = setOf(1, 2, 3, 4, 5)
    val set72: Set<Int> = setOf(4, 6, 5, 7, 9, 1)
    val set73: MutableSet<Int> = mutableSetOf()
    for (i in set71) {
        for (j in set72) {
            if(i == j) {
                set73.add(i)
            }
        }
    }
    println(set73.joinToString())

//Создайте два множества строк и найдите разность первого множества относительно второго (элементы, присутствующие
// в первом множестве, но отсутствующие во втором). Реши задачу через вложенные циклы и переменные флаги.
    val set81: Set<Int> = setOf(1, 2, 3, 4, 5) // 2 3
    val set82: Set<Int> = setOf(4, 6, 5, 7, 9, 1)
    val set83: MutableSet<Int> = mutableSetOf()
    var flag = false
    for (i in set81) {
        for (j in set82) {
            if(i == j) {
                flag = true
            }
        }
        if (!flag) {
            set83.add(i)
        }
        flag = false
    }
    println(set83.joinToString())

//Создайте множество строк и конвертируйте его в список с использованием цикла.
    val set91: Set<String> = setOf("Kotlin", "Java", "Swift")
    val list91: MutableList<String> = mutableListOf()
    for (i in set91) {
        list91.add(i)
    }
    println(list91.joinToString())
}

fun example1(array9: Array<String>, str: String) {
    for (i in array9) {
        if (i.contains(str)) {
            println(i)
        }
    }
}

fun example2(set: Set<String>, str: String) {
    var result = false
    for (i in set) {
        if (i == str) {
            result = !result
        } else {
            result
        }
    }
    println(result)
}