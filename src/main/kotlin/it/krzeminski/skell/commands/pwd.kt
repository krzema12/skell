package it.krzeminski.skell.commands

import java.io.File

val pwd = PrintWorkingDirectory()

class PrintWorkingDirectory : Sequence<File> {
    override fun iterator(): Iterator<File> {
        val currentDir = File("")
        return listOf(currentDir.absoluteFile).toList().iterator()
    }
}
