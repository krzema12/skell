package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext
import java.nio.file.Path

val SkellContext.pwd: Path
    get() = currentPath.toFile().canonicalFile.toPath()

val pwd = defaultContext.pwd
