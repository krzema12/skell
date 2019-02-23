import it.krzeminski.skell.commands.*
import it.krzeminski.skell.environment.variables.USER

fun main(args: Array<String>) =
        command().forEach(::println)

fun command() =
        ls . grep("out")
//        sequenceOf("Current user name: $USER")
//        sequenceOf(pwd)
