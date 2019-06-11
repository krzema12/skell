package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import java.nio.file.Path

val SkellContext.pwd: Path
    get() = currentPath.toFile().canonicalFile.toPath()
