package it.krzeminski.skell.commands

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.PrintWriter
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

    "reads text from file" {
        val tempDirectoryPath = Files.createTempDirectory("unit-tests")

        val writer = PrintWriter(tempDirectoryPath.resolve("new-file").toFile(), "UTF-8")
        writer.println("foo")
        writer.println("bar")
        writer.close()

        cd(tempDirectoryPath.toAbsolutePath().toString()) {
            val actualReadLines = readFrom(file("new-file"))
            actualReadLines shouldBe listOf("foo", "bar")
        }
    }
})
