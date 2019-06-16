package it.krzeminski.skell.commands

import io.kotlintest.matchers.collections.contain
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.matchers.string.shouldEndWith
import io.kotlintest.should
import io.kotlintest.shouldNot
import io.kotlintest.specs.StringSpec
import it.krzeminski.skell.skellContext
import java.nio.file.Files

class MkdirCommandTest : StringSpec({
    "creates a new directory" { skellContext {
        val tempDirectoryPath = Files.createTempDirectory("unit-tests")
        cd(tempDirectoryPath.toAbsolutePath().toString()) {
            pwd.toString() shouldContain "unit-tests"

            ls().map { it.name } shouldNot contain("newDirectory")

            mkdir("newDirectory")

            ls().map { it.name } should contain("newDirectory")
        }
    } }
})
