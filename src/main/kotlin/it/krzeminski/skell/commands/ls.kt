package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import java.io.File

val SkellContext.ls: Iterable<File>
    get() = currentPath.toFile().listFiles().toList()
