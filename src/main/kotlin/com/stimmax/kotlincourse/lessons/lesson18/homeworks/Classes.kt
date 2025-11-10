package org.example.com.stimmax.kotlincourse.lessons.lesson18.homeworks

// 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать
// температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие
// интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание
// на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла
// при выключенном питании - добавь эту проверку.
class FridgeHaier(
    override val maxTemperature: Int,
) : EquipmentWithTemperatureAndOpen() {

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
}


class WasherSamsung(
    override val maxTemperature: Int
) : EquipmentWithTemperatureAndOpen() {

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
}


class TeapotTefal(
    override val maxTemperature: Int
) : EquipmentWithTemperatureAndOpen() {

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
}


class OvenGorenje(
    override val maxTemperature: Int
) : EquipmentWithTemperatureAndOpen() {

    override fun open() {
        println("Духовка открыта")
    }

    override fun close() {
        println("Духовка закрыта")
    }

    override fun setTemperature(temp: Int) {
        if (isPower) {
            println("Задана температура: $temp")
        } else {
            println("Включите духовку")
        }
    }
}