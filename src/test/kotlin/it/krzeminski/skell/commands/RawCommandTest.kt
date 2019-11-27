package it.krzeminski.skell.commands

import io.kotlintest.matchers.string.beEmpty
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class RawCommandTest : StringSpec({
    "raw command as string, after 'cd', when only stdout" {
        cd(".") {
            val (stdout, stderr) = raw("ls", "-l")

            stdout shouldContain "build.gradle.kts"
            stderr should beEmpty()
        }
    }

    "raw command as string, after 'cd', when only stderr" {
        cd(".") {
            val (stdout, stderr) = raw("ls", "nonexisting-directory")

            stdout should beEmpty()
            stderr shouldContain "No such file or directory"
        }
    }

    "raw command as string, without 'cd'" {
        val (stdout, stderr) = raw("echo", "hello world!")

        stdout shouldContain "hello world!"
        stderr should beEmpty()
    }
})
