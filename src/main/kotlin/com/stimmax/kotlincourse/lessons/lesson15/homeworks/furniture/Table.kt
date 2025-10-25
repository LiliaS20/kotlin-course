package org.example.com.stimmax.kotlincourse.lessons.lesson15.homeworks.Furniture

class Table(
    name: String,
    material: String,
    color: String,
    val size: String
) : Kitchen(name, material, color) {
}