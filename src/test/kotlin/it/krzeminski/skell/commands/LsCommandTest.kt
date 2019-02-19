package it.krzeminski.skell.commands

import io.kotlintest.matchers.collections.contain
import io.kotlintest.should
import io.kotlintest.specs.StringSpec

class LsCommandTest : StringSpec({
    "contains some file from project's root directory" {
        // This test is just some sanity check for now.
        // It will be improved once it will be possible to pass a path to 'ls', or call 'cd' before 'ls'.

        val allFiles = ls

        allFiles.map { file -> file.name } should contain("build.gradle.kts")
    }
})
