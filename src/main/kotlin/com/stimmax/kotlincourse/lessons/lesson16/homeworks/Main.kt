package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks

import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals.Animal
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals.Bird
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals.Cat
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.animals.Dog
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.cart.CartOfGoods
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure.Circle
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure.Shape
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure.Square
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.fugure.Triangle
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.logger.Logger
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.printer.InkjetPrinter
import org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.printer.LaserPrinter

fun main() {

    val listAnimal: List<Animal> = listOf(
        Dog(),
        Cat(),
        Bird()
    )

    listAnimal.forEach { it.makeSound("\u001B[31m") }

    val listShape: List<Shape> = listOf(
        Circle(4.3),
        Square(5.3),
        Triangle(4.3, 5.6)
    )

    listShape.forEach { println("Площадь = ${it.area()}") }

    val laserPrinter = LaserPrinter()
    laserPrinter.print("Lorem Ipsum is simply dummy text")

    val inkjetPrinter = InkjetPrinter()
    inkjetPrinter.print("Lorem Ipsum is simply dummy text of the printing and typesetting " +
            "industry. Lorem Ipsum has been the industry's standard dummy text ever since the " +
            "1500s, when an unknown printer took a galley of type and scrambled it to make a " +
            "type specimen book. It has survived not only five centuries, but also the leap " +
            "into electronic typesetting, remaining essentially unchanged. It was popularised " +
            "in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
            "and more recently with desktop publishing software like Aldus PageMaker including " +
            "versions of Lorem Ipsum.")

    val cart = CartOfGoods()
    println(cart.addToCart(1))
    println(cart.addToCart(4))
    println(cart.addToCart(1))

    println(cart.addToCart(1, 5))
    println(cart.addToCart(2, 4))
    println(cart.addToCart(3, 4))


    println(cart.addToCart(listOf(2, 5)))
    println(cart.toString())

    val logger = Logger()
    logger.log("Lorem Ipsum is simply dummy text of the printing")
    logger.log("Lorem Ipsum is simply dummy text of the printing", "WARNING")
    logger.log("Lorem Ipsum is simply dummy text of the printing", "ERROR")
    logger.log("Lorem Ipsum is simply dummy text of the printing", "INFO")

    logger.log(listOf(
        "Lorem Ipsum is simply dummy text of the printing",
        "Lorem Ipsum is simply dummy text of the printing",
        "Lorem Ipsum is simply dummy text of the printing"
    ))

    try {
        throw ArrayIndexOutOfBoundsException("Lorem Ipsum is simply dummy text of the printing")
    } catch (e: ArrayIndexOutOfBoundsException) {
        logger.log(e)
    }

}