package org.example.com.stimmax.kotlincourse.lessons.lesson18.homeworks

fun main() {

    val fridge1 = FridgeHaier(10)
    fridge1.powerOn()
    fridge1.open()
    fridge1.close()
    fridge1.powerOff()
    fridge1.setTemperature(5)
    fridge1.powerOn()
    fridge1.setTemperature(5)

    val washer1 = WasherSamsung(60, "тип1", 4, 6)
    washer1.powerOn()
    washer1.open()
    washer1.close()
    washer1.powerOff()
    washer1.setTemperature(30)
    washer1.powerOn()
    washer1.setTemperature(30)

}