package it.krzeminski.skell.commands

import it.krzeminski.skell.internal.CurrentWorkingDirectoryState

fun cd(directoryName: String) {
    CurrentWorkingDirectoryState.currentDirectory =
        CurrentWorkingDirectoryState.currentDirectory.resolve(directoryName)
}
