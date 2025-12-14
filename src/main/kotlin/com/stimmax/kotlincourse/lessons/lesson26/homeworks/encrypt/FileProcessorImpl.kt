package org.example.com.stimmax.kotlincourse.lessons.lesson26.homeworks.encrypt

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class FileProcessorImpl : FileProcessor {
    override fun findFilesByExtension(
        extension: String,
        directory: File
    ): List<File> {
        val list = mutableListOf<File>()
        directory.walk().forEach {
            if (it.isFile && it.name.endsWith(".$extension")) {
                list.add(it)
            }
        }
        return list.toList()
    }

    override fun encryptFiles(
        files: List<File>,
        encryptor: Encryptor
    ) {
        files.forEach { fileOriginal ->
            File("$fileOriginal-enc").apply {
                parentFile?.mkdirs()
                createNewFile()
                val text = encryptor.encrypt(fileOriginal.readText())
                writeText(text)
            }
        }
    }

    override fun moveToBackup(
        files: List<File>,
        backupDir: File,
        base: File
    ) {
        files.forEach {
            val relativePath = base.toPath().relativize(it.toPath())
            val targetFile = backupDir.toPath().resolve(relativePath).toFile()
            if (!it.exists()) {
                Files.move(it.toPath(), targetFile.toPath())
            } else {
                it.copyTo(File("$targetFile"), overwrite = true)
                it.delete()
            }
        }
    }
}