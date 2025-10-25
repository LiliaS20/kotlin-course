package org.example.com.stimmax.kotlincourse.lessons.lesson15.homeworks.materials

class Task4 : Materials() {

    fun AddMaterialsFirst(name: String){
        val materials = extractMaterials()
        addMaterial(name)
        materials.forEach { addMaterial(it) }
    }
}