package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.cart

open class CartOfGoods {

    private val goods = mutableMapOf<Int, Int>()

    fun addToCart(itemId: Int) {
        goods[itemId] = goods.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: Int, amount: Int) {
        goods[itemId] = goods.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(map: Map<Int, Int>) {
        map.forEach { addToCart(it.key, it.value) }
    }

    fun addToCart(listItemId: List<Int>) {
        listItemId.forEach { addToCart(it) }
    }

    override fun toString(): String {
        val countId = goods.size
        val countAmount = goods.values.sum()
        val list = goods.map { "Артикул: ${it.key}       Количество: ${it.value}" }
            .joinToString("\n")
        return list + "Всего артикулов: $countId\nВсего товаров: $countAmount\n"
    }
}