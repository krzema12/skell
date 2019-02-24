package it.krzeminski.skell.commands

import it.krzeminski.skell.internal.CurrentWorkingDirectoryState
import java.io.File

val ls: Iterable<File>
    get() = CurrentWorkingDirectoryState.currentDirectory.listFiles().toList()
