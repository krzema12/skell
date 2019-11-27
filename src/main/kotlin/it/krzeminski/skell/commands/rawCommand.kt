package it.krzeminski.skell.commands

import it.krzeminski.skell.SkellContext
import it.krzeminski.skell.defaultContext
import java.time.Duration
import java.util.concurrent.TimeUnit

data class CommandOutput(val stdout: String, val stderr: String)

val SkellContext.raw: RawCommand get() = defaults(this)

val raw: RawCommand get() = defaultContext.raw

operator fun RawCommand.invoke(vararg parameters: String): CommandOutput {
    val process = ProcessBuilder(*parameters)
        .directory(skellContext.currentPath.toFile())
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    process.waitFor(commandTimeout.seconds, TimeUnit.SECONDS)

    return CommandOutput(
        stdout = process.inputStream.bufferedReader().readText(),
        stderr = process.errorStream.bufferedReader().readText())
}

data class RawCommand(val skellContext: SkellContext, val commandTimeout: Duration)

private fun defaults(skellContext: SkellContext) =
    RawCommand(skellContext = skellContext, commandTimeout = Duration.ofHours(1))
