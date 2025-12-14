package org.example.com.stimmax.kotlincourse.lessons.lesson26.homeworks.encrypt

import java.io.File

class EncryptionManager(
    private val fileProcessor: FileProcessor,
    private val encryptor: Encryptor) {

    fun encryptFilesInDirectory(directory: File, backupDir: File, extension: String) {
        val filesEnc = fileProcessor.findFilesByExtension(extension, directory)
        fileProcessor.encryptFiles(filesEnc, encryptor)
        fileProcessor.moveToBackup(filesEnc, backupDir, directory)
        println("Шифрование завершено")
    }
}