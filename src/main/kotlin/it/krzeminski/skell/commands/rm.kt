package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext

fun SkellContext.rm(fileName: String) =
    currentPath.resolve(fileName).toFile().delete()

fun rm(fileName: String) = defaultContext.rm(fileName)
