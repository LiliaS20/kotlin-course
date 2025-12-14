package org.example.com.stimmax.kotlincourse.lessons.lesson26.homeworks.encrypt

import java.io.File

fun main() {

//Задача "Шифровальщик"
//Цель задания:
//
//Практика работы с файлами в Kotlin.
//Использование интерфейсов и реализация классов в Kotlin.
//Задача:
//
//Вам необходимо создать простую систему шифрования файлов. Система должна уметь находить файлы по указанному расширению, шифровать содержимое найденных файлов и записывать зашифрованные данные в новые файлы. Оригинальные файлы нужно переместить в директорию backup с сохранением их относительных путей.
//
//Шаги реализации:
//
//Определите два интерфейса:
//
//FileProcessor с методами:
//findFilesByExtension(extension: String, directory: File): List<File>
//encryptFiles(files: List<File>, encryptor: Encryptor)
//moveToBackup(files: List<File>, backupDir: File, base: File)
//Encryptor с методом:
//encrypt(content: String): String
//Реализуйте два класса:
//
//FileProcessorImpl, реализующий FileProcessor.
//EncryptorImpl, реализующий Encryptor.
//Создайте класс EncryptionManager, который:
//
//Принимает объекты FileProcessor и Encryptor в своём конструкторе.
//Имеет метод encryptFilesInDirectory(directory: File, backupDir: File, extension: String), который инициирует процесс поиска, шифрования и перемещения файлов.
//Условия выполнения:
//
//Используйте простой алгоритм шифрования, например, сдвиг символов на фиксированное число позиций в алфавите.
//При перемещении файлов в директорию backup сохраняйте относительные пути файлов относительно исходной директории.
//Для тестирования создайте несколько тестовых файлов разных типов и выполните шифрование.
//Тестирование:
//
//Проверьте работу системы шифрования на разных директориях и файлах.
//Убедитесь, что зашифрованные файлы корректно создаются, а оригинальные файлы переносятся в директорию backup.
//Протестируйте систему на различных типах файлов и разных уровнях вложенности директорий.

    val testDir1 = File("workspace/task9/f1")
    if (!testDir1.exists()) {
        testDir1.mkdirs()
    }

    val testDir2 = File("workspace/task9/f2")
    if (!testDir2.exists()) {
        testDir2.mkdirs()
    }

    val file1 = File(testDir1, "text1.txt")
    file1.writeText("Текст 1")
    val file2 = File(testDir2, "text2.txt")
    file2.writeText("Текст 2")
    val file3 = File(testDir1, "json1.json")
    file3.writeText("json")

    val backupDir = File("workspace/task9/backup")
    if (!backupDir.exists()) {
        backupDir.mkdirs()
    }

    val fileProcessor = FileProcessorImpl()
    val encryptor = EncryptorImpl()
    val encryptionManager = EncryptionManager(fileProcessor, encryptor)

    encryptionManager.encryptFilesInDirectory(testDir1, backupDir, "txt")
    encryptionManager.encryptFilesInDirectory(testDir2, backupDir, "txt")
    encryptionManager.encryptFilesInDirectory(testDir1, backupDir, "json")
}