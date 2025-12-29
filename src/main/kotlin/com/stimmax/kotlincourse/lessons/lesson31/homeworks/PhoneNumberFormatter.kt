package org.example.com.stimmax.kotlincourse.lessons.lesson31.homeworks

class PhoneNumberFormatter {

    fun formatPhoneNumber(phoneNumber: String): String {
        val digits = phoneNumber.replace("\\D".toRegex(), "")

        if (digits.length !in 10..11) {
            throw IllegalArgumentException("Invalid phone number length")
        }

        val cleanedNumber = if (digits.length == 11) {
            if (digits.startsWith("8")) {
                digits.substring(1)
            } else if (digits.startsWith("7")) {
                digits.substring(1)
            } else {
                throw IllegalArgumentException("Invalid phone number: should start with 8 or 7")
            }
        } else {
            digits
        }

        val areaCode = cleanedNumber.substring(0, 3)
        val prefix = cleanedNumber.substring(3, 6)
        val lineNumber = cleanedNumber.substring(6, 8)
        val extension = cleanedNumber.substring(8, 10)

        return "+7 ($areaCode) $prefix-$lineNumber-$extension"
    }
}