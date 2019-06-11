import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.commands.*
import it.krzeminski.skell.environment.variables.HOME
import it.krzeminski.skell.environment.variables.USER
import it.krzeminski.skell.skellContext

fun main(args: Array<String>) = skellContext {
    command().forEach(::println)
}

fun SkellContext.command() =
    ls . grep("out")
//        sequenceOf("Current user name: $USER, and its home directory is: $HOME")
//        sequenceOf(pwd)
