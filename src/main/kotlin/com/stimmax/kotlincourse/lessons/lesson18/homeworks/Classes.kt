package org.example.com.stimmax.kotlincourse.lessons.lesson18.homeworks

import java.io.InputStream

// 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать
// температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие
// интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание
// на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла
// при выключенном питании - добавь эту проверку.
class FridgeHaier(
    override val maxTemperature: Int
) : Fridge() {

    override fun open() {
        println("Холодильник открыт")
    }

    override fun close() {
        println("Холодильник закрыт")
    }

    override fun setTemperature(temp: Int) {
        if (isPower) {
            println("Задана температура: $temp")
        } else {
            println("Включите холодильник")
        }
    }

    override fun connectToWaterSupply() {
        println("Подключить воду")
    }

    override fun getWater(amount: Int) {
        println("Залить $amount воды")
    }
}


class WasherSamsung(
    override val maxTemperature: Int,
    override val sensorType: String,
    override val maxSensoredValue: Int,
    override val capacity: Int
) : Washer() {

    override fun open() {
        println("Стиральная машина открыта")
    }

    override fun close() {
        println("Стиральная машина закрыта")
    }

    override fun setTemperature(temp: Int) {
        if (isPower) {
            println("Задана температура: $temp")
        } else {
            println("Включите стиральную машину")
        }
    }

    override fun connectToWaterSupply() {
        println("Подключить воду")
    }

    override fun fillWater(amount: Int) {
        println("Залить $amount воды")
    }

    override fun getWater(amount: Int) {
        println("Залить $amount воды")
    }

    override fun startMonitoring() {
        println("Начать мониторинг")
    }

    override fun connectToDrain() {
        println("Подключить слив")
    }

    override fun drain() {
        println("Слить воду")
    }

    override fun setTimer(time: Int) {
        println("Установить таймер на $time")
    }
}


class TeapotTefal(override val maxTemperature: Int) : Fridge() {

    override fun open() {
        println("Чайник открыт")
    }

    override fun close() {
        println("Чайник закрыт")
    }

    override fun setTemperature(temp: Int) {
        if (isPower) {
            println("Задана температура: $temp")
        } else {
            println("Включите чайник")
        }
    }

    override fun connectToWaterSupply() {
        println("Подключить воду")
    }

    override fun getWater(amount: Int) {
        println("Залить $amount воды")
    }
}


class OvenGorenje(
    override val sensorType: String,
    override val maxSensoredValue: Int,
    override val capacity: Int,
    override val maxTemperature: Int
) : Oven() {

    override fun startMonitoring() {
        println("Начать мониторинг")
    }

    override fun setTimer(time: Int) {
        println("Установить таймер на $time")
    }

    override fun fillWater(amount: Int) {
        println("Залить $amount воды")
    }

    override fun getWater(amount: Int) {
        println("Залить $amount воды")
    }

    override fun connectToWaterSupply() {
        println("Подключить воду")
    }

    override fun connectToDrain() {
        println("Подключить слив")
    }

    override fun drain() {
        println("Слить воду")
    }
}