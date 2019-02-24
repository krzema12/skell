package it.krzeminski.skell.commands

import it.krzeminski.skell.internal.CurrentWorkingDirectoryState
import java.io.File

val pwd: File
    get() = CurrentWorkingDirectoryState.currentDirectory.canonicalFile
