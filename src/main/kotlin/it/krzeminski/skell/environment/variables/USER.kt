package it.krzeminski.skell.environment.variables

val USER: String
    get() = System.getProperty("user.name")
