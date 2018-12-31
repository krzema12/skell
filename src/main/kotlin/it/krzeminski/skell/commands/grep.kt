package it.krzeminski.skell.commands

fun <T> Sequence<T>.grep(regex: String): Sequence<T>
        = filter { Regex(regex).containsMatchIn(it.toString()) }