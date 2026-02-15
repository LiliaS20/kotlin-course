package org.example.com.stimmax.kaspressolearning.lessons.lesson04.homework


//1. Доступ к элементу по индексу ([ ]) и проверка наличия через in
//Есть класс Inventory, внутри которого хранится список строк items.
//Перегрузи оператор + чтобы добавлять новые элементы в список.
//Перегрузи оператор [ ], чтобы получать предмет по индексу.
//Перегрузи оператор in, чтобы проверять вхождение строки в список items.
class Inventory {

    private val items = mutableListOf<String>()

    operator fun plus(str: String) {
        items.add(str)
    }

    operator fun get(index: Int): String {
        return items[index]
    }

    operator fun contains(str: String): Boolean {
        return str in items
    }

    fun getInventory() = items
}

//2. Инверсия состояния (!)
//Есть класс Toggle с полем enabled: Boolean.
//Перегрузи оператор !, чтобы он возвращал новый объект с противоположным состоянием.
class Toggle(private val enabled: Boolean) {

    operator fun not(): Toggle {
        return Toggle(!enabled)
    }

    override fun toString(): String {
        return "$enabled"
    }

}

//3. Умножение значения (*)
//Есть класс Price с полем amount: Int.
//Перегрузи оператор *, чтобы можно было умножать цену на целое число (например, количество товаров).
class Price(val amount: Int) {

    operator fun times(count: Int): Int {
        return amount * count
    }
}

//4. Диапазон значений (..)
//Есть класс Step с полем number: Int.
//Перегрузи оператор .., чтобы можно было создавать диапазон шагов между двумя объектами Step.
//Сделай возможной проверку: входит ли один Step в диапазон шагов с помощью оператора in. Обрати внимание,
// что это обратная операция и нужно расширять класс IntRange для проверки вхождения в него Step.
class Step(val number: Int) {

    operator fun rangeTo(other: Step): IntRange {
        return number..other.number
    }

    operator fun contains(range: IntRange): Boolean {
        return number in range
    }
}

operator fun IntRange.contains(step: Step): Boolean {
    return step.number in this
}

//5. Последовательное объединение (+)
//Есть класс Log с полем entries: List<String>.
//Перегрузи оператор +, чтобы при сложении логов записи объединялись в один лог.
class Log() {

    private val entries = mutableListOf<String>()

    operator fun plus(log: String): Log {
        entries.add(log)
        return this
    }

    fun print() {
        println(entries.joinToString())
    }
}

// 6.Генератор фраз.
//Используй класс Person из "общих рекомендаций" ниже. Добавь в этот класс три инфиксные функции:
//says должна принимать строку, добавлять её в список фраз и возвращать этот же объект Person для дальнейшей работы.
// Всегда вызывается первой.
//and работает так же как и says, но не может быть вызвана первой (в этом случае нужно выкидывать IllegalStateException).
//or должна принимать строку и заменять последнюю фразу в списке фраз, выбирая случайным образом переданную строку или
// последнюю фразу из списка фраз с помощью метода selectPhrase. Так же должна возвращать текущий объект Person
// для дальнейшей работы. Так же не может быть вызвана первой, иначе выбрасывает IllegalStateException.


fun main() {

    // 1
    val inventory = Inventory()
    inventory + "a"
    inventory + "b"
    inventory + "c"
    inventory + "d"
    println(inventory.getInventory())
    println(inventory[2])
    println("v" in inventory)
    println("a" in inventory)

    // 2
    val toggle = Toggle(true)
    println(!toggle)

    // 3
    val price = Price(10)
    println(price * 4)

    // 4
    val step = Step(10)
    println(step..Step(14))
    println(step..Step(4))
    println(4 in (step..Step(14)))
    println(11 in (step..Step(14)))

    // 5
    val log = Log()
    log + "dd"
    log + "dd"
    log + "dd"
    log.print()
}