package it.krzeminski.skell.commands

import io.kotlintest.matchers.collections.contain
import io.kotlintest.should
import io.kotlintest.shouldNot
import io.kotlintest.specs.StringSpec
import java.nio.file.Files

class TouchCommandTest : StringSpec({
    "creates a new directory" {
        val tempDirectoryPath = Files.createTempDirectory("unit-tests")
        cd(tempDirectoryPath.toAbsolutePath().toString()) {
            ls().map { it.name } shouldNot contain("newFile")

            touch("newFile")

            ls().map { it.name } should contain("newFile")
        }
    }
})
