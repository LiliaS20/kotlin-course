package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    //  В конструкторе ChildrenClass указана переменная с идентичным именем из BaseClass
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main()
    // Члены класса доступны внутри класса и в производных классах
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main() - BaseClass менять нельзя, а в " +
            "ChildrenClass поле не видно"
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. объясни, почему эта функция не может быть публичной
    // потому что возвращает класс с protected, доступ должен быть только у текущего класса и его наследников
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // потому что этот метод переопределен в дочернем классе
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    // потому что возвращает приватный класс
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // потому что в BaseClass есть публичное поле с таким именем и вызывается оно
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // потому что функция getAll() есть в родительском классе
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // в BaseClass privatePrint вызывается в публичном методе printText, в ChildrenClass переопределенного
    // printText нет, поэтому вызывается родительский
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 4.
    override fun verifyPublicField(value: String): Boolean {
        return true
    }

    // 5.
    fun set1ProtectedField(str: String) {
        protectedField = str
    }
}

fun main() {

    val children1 = ChildrenClass("privateVal", "protectedVal", "publicVal")
    // 3.
    children1.publicField = "Антонио Бандерас"
    println(children1.getAll())

    // 5.
    children1.set1ProtectedField("5 задание")
    println(children1.getAll())
    children1.printText()

}