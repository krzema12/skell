package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext

fun SkellContext.cd(path: String, block: SkellContext.() -> Unit) {
    val newContext = this.copy(currentPath = currentPath.resolve(path))
    newContext.block()
}

fun cd(path: String, block: SkellContext.() -> Unit) = defaultContext.cd(path, block)
