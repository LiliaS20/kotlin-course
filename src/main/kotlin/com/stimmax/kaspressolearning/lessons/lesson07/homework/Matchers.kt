package org.example.com.stimmax.kaspressolearning.lessons.lesson07.homework

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeDiagnosingMatcher

enum class Color {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    BLACK,
    WHITE
}

data class Shape(val length: Float, val count: Int, val color: Color)

//Проверка длины стороны в заданном диапазоне (например, от 0.1 до 100.0).
class FromLengthMatcher(
    private val expectedLength: Float
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.length < expectedLength) {
            mismatchDescription.appendText("длина стороны = ")
                .appendValue(item.length)
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("длина должна быть больше ")
            .appendValue(expectedLength)
    }
}

class ToLengthMatcher(
    private val expectedLength: Float
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.length > expectedLength) {
            mismatchDescription.appendText("длина стороны = ")
                .appendValue(item.length)
        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("длина стороны должна быть меньше ")
            .appendValue(expectedLength)
    }
}

//Проверка количества углов:
//Для фигур с 3 и более сторонами количество углов совпадает с количеством сторон.
//Для фигур с 1 или 2 сторонами (линий) углы отсутствуют (значение углов = 0).
class CornerMatcher(
    private val expectedCorner: Int
) : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        val currentCorner = if (item.count > 2) 0 else item.count
        return (expectedCorner == currentCorner).also {
            if (!it) {
                mismatchDescription.appendText("количество углов = ")
                    .appendValue(currentCorner)
            }
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("количество углов должно быть ")
            .appendValue(expectedCorner)
    }
}

//Проверка на чётное количество сторон.
class EvenSideCountMatcher() : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        return (item.count % 2 == 0).also {
            if (!it) {
                mismatchDescription.appendText("количество углов нечетное")
            }
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("количество углов четное")
    }
}

//Проверка цвета фигуры.
class ShapeColorMatcher(
    private val expectedColor: Color
) : TypeSafeDiagnosingMatcher<Shape>() {
    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        if (item.color != expectedColor) {
            mismatchDescription.appendText("цвет фигуры ")
                .appendValue(item.color)

        }
        return true
    }

    override fun describeTo(description: Description) {
        description.appendText("цвет фигуры должен быть")
            .appendValue(expectedColor)
    }
}

//Проверка на наличие отрицательной длины стороны (недопустимо).
class NegativeSideLengthMatcher : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        return (item.length >= 0).also {
            if (!it) mismatchDescription.appendText("длина стороны отрицательная")
        }
    }
    override fun describeTo(description: Description) {
        description.appendText("длина стороны больше 0")
    }
}

//Проверка на наличие отрицательного количества сторон (недопустимо).
class NegativeSidesMatcher : TypeSafeDiagnosingMatcher<Shape>() {

    override fun matchesSafely(
        item: Shape,
        mismatchDescription: Description
    ): Boolean {
        return (item.count >= 0).also {
            if (!it) {
                mismatchDescription.appendText("количество сторон отрицательное")
            }
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("количество сторон больше 0")
    }
}

fun main() {

    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    fun hasCorners(cornerNumber: Int) = CornerMatcher(cornerNumber)
    fun hasValidSides() = NegativeSidesMatcher()
    fun hasValidSideLength() = NegativeSideLengthMatcher()
    fun hasSideLengthInRange(min: Float) = FromLengthMatcher(min)
    fun has1SideLengthInRange(max: Float) = ToLengthMatcher(max)
    fun hasEvenSides() = EvenSideCountMatcher()
    fun hasColor(expectedColor: Color) = ShapeColorMatcher(expectedColor)

// Фильтрация с использованием allOf
    val filteredShapes = shapes.filter { shape ->
        allOf(
            hasSideLengthInRange(1f),
            has1SideLengthInRange(100f),
            hasEvenSides(),
            hasValidSideLength(),
            hasValidSides()
        ).matches(shape)
    }
    println(filteredShapes)

    fun testMatchers() {
        val shape = Shape(10f, 4, Color.RED)
        hasSideLengthInRange(1f)
        has1SideLengthInRange(100f)
        assertThat(shape, hasColor(Color.RED))
        assertThat(shape, hasValidSideLength())
        assertThat(shape, hasValidSides())
    }

    testMatchers()
    println("Фигуры, прошедшие фильтрацию: $filteredShapes")

}