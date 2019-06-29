import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.commands.*
import it.krzeminski.skell.environment.variables.HOME
import it.krzeminski.skell.environment.variables.USER

fun main(args: Array<String>) =
    command().forEach(::println)

fun command() =
    ls() . grep("out")
//        sequenceOf("Current user name: $USER, and its home directory is: $HOME")
//        sequenceOf(pwd)
