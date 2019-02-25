package it.krzeminski.skell.commands

import it.krzeminski.skell.internal.CurrentWorkingDirectoryState

fun mkdir(directoryName: String) {
    CurrentWorkingDirectoryState.currentDirectory.resolve(directoryName).mkdir()
}
