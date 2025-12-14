package org.example.com.stimmax.kotlincourse.lessons.lesson26.homeworks.encrypt

import java.io.File

interface FileProcessor {
    fun findFilesByExtension(extension: String, directory: File): List<File>
    fun encryptFiles(files: List<File>, encryptor: Encryptor)
    fun moveToBackup(files: List<File>, backupDir: File, base: File)
}