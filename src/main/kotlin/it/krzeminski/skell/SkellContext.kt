package it.krzeminski.skell

import java.nio.file.Path
import java.nio.file.Paths

data class SkellContext(val currentPath: Path)

val defaultContext = SkellContext(currentPath = Paths.get("."))
