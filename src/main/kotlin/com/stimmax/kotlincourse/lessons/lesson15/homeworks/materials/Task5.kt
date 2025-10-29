package org.example.com.stimmax.kotlincourse.lessons.lesson15.homeworks.materials

import kotlin.math.max

class Task5 : Materials() {

    fun addList(list: List<String>){

        val materials = extractMaterials()
        val index = max(list.lastIndex, materials.lastIndex)
        for (i in 0 until index) {
            if (i < list.size) {
                addMaterial(list[i])
            }
            if (i < materials.size) {
                addMaterial(materials[i])
            }
        }
    }
}