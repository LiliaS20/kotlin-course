package org.example.com.stimmax.kotlincourse.lessons.lesson18.homeworks


// 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс
// с реализацией методов (достаточно println с выполняемым действием).
abstract class Fridge() :
    Powerable,
    Openable,
    TemperatureRegulatable,
    WaterConnection {

    protected var isPower: Boolean = false

    override fun powerOff() {
        println("Выключен")
        isPower = false
    }

    override fun powerOn() {
        println("Включен")
        isPower = true
    }

}

// 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса
// и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
abstract class Washer :
    Powerable,
    Openable,
    WaterContainer,
    TemperatureRegulatable,
    WaterConnection,
    AutomaticShutdown,
    Drainable,
    Timable,
    Programmable,
    Fridge() {

    override fun programAction(action: String) {
        println("Действие программы")
    }

    override fun execute() {
        println("Запустить программу")
    }
}

// 4. . Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и
// с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class Oven() :
    Powerable,
    Openable,
    TemperatureRegulatable,
    AutomaticShutdown,
    Timable,
    Programmable,
    Washer() {

    override fun open() {
        println("Открыть")
    }

    override fun close() {
        println("Закрыть")
    }

    override fun setTemperature(temp: Int) {
        println("Установить температуру")
    }
}

abstract class SmartLamp :
    Powerable,
    AutomaticShutdown,
    Timable,
    LightEmitting

abstract class ElectronicWatches :
    BatteryOperated,
    LightEmitting,
    SoundEmitting,
    Programmable,
    Rechargeable

abstract class RobotVacuumCleaner :
    Powerable,
    Openable,
    WaterContainer,
    AutomaticShutdown,
    Timable,
    BatteryOperated,
    SoundEmitting,
    Programmable,
    Movable,
    Cleanable,
    Rechargeable

abstract class MechanicalWatches : Mechanical

abstract class Lantern : BatteryOperated, LightEmitting, Rechargeable

abstract class CoffeeMachine :
    Powerable,
    Openable,
    WaterContainer,
    AutomaticShutdown,
    Drainable,
    Programmable,
    Cleanable

abstract class SmartSpeaker :
    Powerable,
    Timable,
    LightEmitting,
    SoundEmitting,
    Programmable