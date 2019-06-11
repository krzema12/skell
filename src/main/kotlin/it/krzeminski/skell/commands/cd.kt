package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext

fun SkellContext.cd(path: String, block: SkellContext.() -> Unit) {
    val newContext = this.copy(currentPath = currentPath.resolve(path))
    newContext.block()
}
