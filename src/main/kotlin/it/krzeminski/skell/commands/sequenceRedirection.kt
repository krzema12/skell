package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files

infix fun Iterable<String>.writeTo(file: File) {
    val writer = PrintWriter(file, "UTF-8")
    this.forEach { line ->
        writer.println(line)
    }
    writer.close()
}

fun readFrom(file: File): Iterable<String> =
    Files.readAllLines(file.toPath())

fun SkellContext.file(path: String): File = currentPath.resolve(path).toFile()
