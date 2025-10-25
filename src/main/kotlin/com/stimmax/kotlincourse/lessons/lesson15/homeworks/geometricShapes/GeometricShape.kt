package org.example.com.stimmax.kotlincourse.lessons.lesson15.homeworks.geometricShapes

open class GeometricShape(
    val color: String,
    val border: Boolean,
    val name: String
) {
    open fun getName() {
        println(name)
    }
}