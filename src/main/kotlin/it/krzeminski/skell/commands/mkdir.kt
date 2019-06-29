package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext

fun SkellContext.mkdir(directoryName: String) =
    currentPath.resolve(directoryName).toFile().mkdir()

fun mkdir(directoryName: String) = defaultContext.mkdir(directoryName)
