package it.krzeminski.skell.commands

import io.kotlintest.matchers.string.shouldEndWith
import io.kotlintest.matchers.string.shouldNotEndWith
import io.kotlintest.specs.StringSpec

class PwdCommandTest : StringSpec({
    "current directory set with 'cd' is respected" {
        val pwdBeforeDirectoryChange = pwd
        cd("src") {
            val pwdAfterDirectoryChange = pwd

            pwdBeforeDirectoryChange.toString() shouldNotEndWith "src"
            pwdAfterDirectoryChange.toString() shouldEndWith "src"
        }
    }
})
