package it.krzeminski.skell.environment.variables

import java.io.File

val HOME: File
    get() = File(System.getProperty("user.home"))
