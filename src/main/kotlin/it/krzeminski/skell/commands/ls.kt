package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import java.io.File

val SkellContext.ls: LsCommand get() = defaults(this)

operator fun LsCommand.invoke(path: String = "."): Iterable<File> {
    val initialList = skellContext.currentPath.resolve(path).toFile().listFiles().toList()
    val sortedList = when (sortBy) {
        SortingAttribute.NAME -> initialList.sortedBy { it.name }
        SortingAttribute.MODIFICATION_TIME -> initialList.sortedBy { it.lastModified() }
        SortingAttribute.SIZE -> initialList.sortedBy { it.length() }
    }
    return if (reverseSort) {
        sortedList.reversed()
    } else {
        sortedList
    }
}

data class LsCommand(val skellContext: SkellContext, val sortBy: SortingAttribute, val reverseSort: Boolean)

val LsCommand.t: LsCommand get() = copy(sortBy = SortingAttribute.MODIFICATION_TIME)
val LsCommand.r: LsCommand get() = copy(reverseSort = true)

enum class SortingAttribute {
    NAME,
    MODIFICATION_TIME,
    SIZE
}

private fun defaults(skellContext: SkellContext) =
    LsCommand(skellContext = skellContext, sortBy = SortingAttribute.NAME, reverseSort = false)
