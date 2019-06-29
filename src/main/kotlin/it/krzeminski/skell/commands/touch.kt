package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext

fun SkellContext.touch(fileName: String) =
    currentPath.resolve(fileName).toFile().createNewFile()

fun touch(fileName: String) = defaultContext.touch(fileName)
