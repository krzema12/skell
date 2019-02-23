package it.krzeminski.skell.commands

import java.io.File

val ls: Iterable<File>
    get() = File(".").listFiles().toList()
