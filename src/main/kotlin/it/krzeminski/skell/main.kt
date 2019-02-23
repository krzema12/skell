import it.krzeminski.skell.commands.*

fun main(args: Array<String>) =
        command().forEach(::println)

fun command() =
        ls . grep("out")
//        sequenceOf(pwd)
