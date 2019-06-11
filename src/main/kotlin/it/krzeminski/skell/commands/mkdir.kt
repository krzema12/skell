package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext

fun SkellContext.mkdir(directoryName: String) =
    currentPath.resolve(directoryName).toFile().mkdir()
