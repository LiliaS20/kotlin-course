package org.example.com.stimmax.kotlincourse.lessons.lesson05.homework

fun main() {

//    Задача 1
    var initialSoundIntensity: Double = 5.0
    var coefficient: Double? = null
    val baseCoefficient = 0.5
    val resultIntensity = initialSoundIntensity * (coefficient?: baseCoefficient)
    println(resultIntensity)


//    Задача 2
    val insurance: Double = 0.005
    var defaultCost: Double = 50.0
    var cost: Double? = null
    var costDelivery = insurance * (cost ?: defaultCost)
    var sumDelivery = costDelivery + (cost ?: defaultCost)
    println(sumDelivery)

//    Задача 3
    var pressure: String? = null
    var infoPressure = pressure ?: "показания отсутствуют"
    println(infoPressure)
}