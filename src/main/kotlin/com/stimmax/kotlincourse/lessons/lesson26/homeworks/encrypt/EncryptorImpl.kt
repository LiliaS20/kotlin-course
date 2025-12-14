package org.example.com.stimmax.kotlincourse.lessons.lesson26.homeworks.encrypt

class EncryptorImpl: Encryptor {
    override fun encrypt(content: String): String {
        return content.map { it + 3 }.joinToString("")
    }
}