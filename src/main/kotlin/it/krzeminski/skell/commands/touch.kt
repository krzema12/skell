package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext

fun SkellContext.touch(fileName: String) =
    currentPath.resolve(fileName).toFile().createNewFile()
