package skell

import java.io.File

val ls = ListFilesAndDirectories()

class ListFilesAndDirectories : Sequence<File> {
    override fun iterator(): Iterator<File> {
        val currentDir = File(".")
        return currentDir.listFiles().toList().iterator()
    }
}
