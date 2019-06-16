package it.krzeminski.skell

import io.kotlintest.matchers.string.shouldEndWith
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import it.krzeminski.skell.commands.*
import kotlin.random.Random

class IntegrationTests : StringSpec({
    "creating a file in a newly created directory" {
        var wasCdBodyExecuted = false

        skellContext {
            val randomDirectoryName = "build/newDirectory-${Random.nextInt()}"

            mkdir(randomDirectoryName)
            cd(randomDirectoryName) {
                touch("newFile")
                pwd.toString() shouldEndWith randomDirectoryName
                ls().grep("newFile").count() shouldBe 1
                wasCdBodyExecuted = true
            }
        }

        wasCdBodyExecuted shouldBe true
    }
})
