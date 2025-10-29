package org.example.com.stimmax.kotlincourse.lessons.lesson16.homeworks.cart

open class CartOfGoods {

    private val goods = mutableMapOf<Int, Int>()

    fun addToCart(itemId: Int): MutableMap<Int, Int> {
        goods[itemId] = goods.getOrDefault(itemId, 0) + 1
        return goods
    }

    fun addToCart(itemId: Int, amount: Int): MutableMap<Int, Int> {
        goods[itemId] = goods.getOrDefault(itemId, 0) + amount
        return goods
    }

    fun addToCart(listItemId: List<Int>): MutableMap<Int, Int> {
        listItemId.forEach { goods[it] = goods.getOrDefault(it, 0) + 1 }
        return goods
    }

    override fun toString(): String {
        var countAmount = 0
        var str = ""
        for ((itemId, amount) in goods.toSortedMap()) {
            str += "Артикул: $itemId      Количество: $amount \n"
            countAmount+=amount
        }
        return str + "Всего артикулов: ${goods.size}\nВсего товаров: $countAmount\n"


    }
}