package it.krzeminski.skell.commands

fun <T> Iterable<T>.grep(regex: String): Iterable<T>
        = filter { Regex(regex).containsMatchIn(it.toString()) }
