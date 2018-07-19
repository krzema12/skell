import skell.*

fun main(args: Array<String>) =
        command().forEach(::println)

fun command() =
        ls . grep("out")
//        pwd
