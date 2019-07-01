package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import java.io.File
import java.io.PrintWriter

infix fun Iterable<String>.to(file: File) {
    val writer = PrintWriter(file, "UTF-8")
    this.forEach { line ->
        writer.println(line)
    }
    writer.close()
}

fun SkellContext.file(path: String): File = currentPath.resolve(path).toFile()
