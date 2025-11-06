package org.example.com.stimmax.kotlincourse.lessons.lesson17.homeworks

class GamblingMachine(
    val color: String,
    val model: String,
    val hasController: Boolean
) {
    private var isOn: Boolean = false
    private var osIsLoaded: Boolean = false
    private val listOfGames: MutableList<String> = mutableListOf(
        "Игра 1",
        "Игра 2",
        "Игра 3",
        "Игра 4",
    )
    private var balance: Double = 0.0
    private var owner: String = "Кто-то"
    var supportNumber: String = "79876543210"
    private var gameSessionIsPaid: Boolean = false
    private var costOneGameSession: Double = 100.00
    private var pinCode: String = "1234"

    fun turnOn() {
        isOn = true
        LoadOS()
    }

    fun turnOff() {
        isOn = false
        FinishOS()
    }

    private fun LoadOS() {
        osIsLoaded = true
    }

    private fun FinishOS() {
        osIsLoaded = false
    }

    fun getListOfGames(): List<String> {
        return listOfGames.toList()
    }

    fun startGame(gameName: String) {
        if (gameSessionIsPaid) {
            if (gameName in listOfGames) {
                println("игра запущена")
                gameSessionIsPaid = false
            } else {
                println("такой игры нет")
            }
        } else {
            println("оплати сессию")
        }
    }

    fun payGameSession() {
        balance += costOneGameSession
        gameSessionIsPaid = true
    }

    fun collectCash(pinCode: String) {
        if (pinCode == this.pinCode) {
            println(openSafe())
        } else {
            println("Неверный пин-код")
        }
    }

    private fun openSafe(): Double {
        val cash = balance
        balance = 0.0
        return cash
    }
}

