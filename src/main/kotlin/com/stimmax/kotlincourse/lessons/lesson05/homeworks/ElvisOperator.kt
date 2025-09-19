package org.example.com.stimmax.kotlincourse.lessons.lesson05.homework

fun main() {

//    Задача 1
    val initialSoundIntensity: Double = 5.0
    val coefficient: Double? = null
    val baseCoefficient = 0.5
    val resultIntensity = initialSoundIntensity * (coefficient?: baseCoefficient)
    println(resultIntensity)


//    Задача 2
    val insurance: Double = 0.005
    val defaultCost: Double = 50.0
    val cost: Double? = null
    val costDelivery = insurance * (cost ?: defaultCost)
    val sumDelivery = costDelivery + (cost ?: defaultCost)
    println(sumDelivery)

//    Задача 3
    val pressure: String? = null
    val infoPressure = pressure ?: "показания отсутствуют"
    println(infoPressure)
}