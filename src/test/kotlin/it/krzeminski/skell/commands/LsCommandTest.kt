package it.krzeminski.skell.commands

import io.kotlintest.matchers.collections.contain
import io.kotlintest.should
import io.kotlintest.specs.StringSpec
import it.krzeminski.skell.skellContext

class LsCommandTest : StringSpec({
    "contains some file from project's root directory" { skellContext {
        // This test is just some sanity check for now.
        // It will be improved once it will be possible to pass a path to 'ls', or call 'cd' before 'ls'.

        val allFiles = ls()

        allFiles.map { file -> file.name } should contain("build.gradle.kts")
    } }

    "current directory set with 'cd' is respected" { skellContext {
        val allFilesBeforeDirectoryChange = ls()
        cd("gradle/wrapper") {
            val allFilesAfterDirectoryChange = ls()

            allFilesBeforeDirectoryChange.map { file -> file.name } should contain("build.gradle.kts")
            allFilesAfterDirectoryChange.map { file -> file.name } should contain("gradle-wrapper.jar")
        }
    } }

    "path can be given" { skellContext {
        val allFilesWithoutPathGiven = ls()
        val allFilesWithPathGiven = ls("gradle/wrapper")

        allFilesWithoutPathGiven.map { file -> file.name } should contain("build.gradle.kts")
        allFilesWithPathGiven.map { file -> file.name } should contain("gradle-wrapper.jar")
    } }
})
