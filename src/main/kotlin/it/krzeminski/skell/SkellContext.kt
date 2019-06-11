package it.krzeminski.skell

import java.nio.file.Path
import java.nio.file.Paths

data class SkellContext(val currentPath: Path)

fun skellContext(block: SkellContext.() -> Unit) =
    SkellContext(currentPath = Paths.get(".")).block()
