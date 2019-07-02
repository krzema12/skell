package it.krzeminski.skell.commands

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.nio.file.Files

class SequenceRedirectionTest : StringSpec({
    "writes text to a file" {
        val tempDirectoryPath = Files.createTempDirectory("unit-tests")
        cd(tempDirectoryPath.toAbsolutePath().toString()) {
            listOf("foo", "bar") writeTo file("new-file")
        }

        val actualReadLines = String(Files.readAllBytes(tempDirectoryPath.resolve("new-file")))
        actualReadLines shouldBe "foo\nbar\n"
    }
})
