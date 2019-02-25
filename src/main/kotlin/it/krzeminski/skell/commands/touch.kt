package it.krzeminski.skell.commands

import it.krzeminski.skell.internal.CurrentWorkingDirectoryState

fun touch(fileName: String) {
    CurrentWorkingDirectoryState.currentDirectory.resolve(fileName).createNewFile()
}
