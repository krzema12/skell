import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.clikt.parameters.arguments.validate
import com.github.ajalt.clikt.parameters.types.path
import java.nio.file.Path

private class Synthesize : CliktCommand(name = "skell1") {
    val VARIABLE_1: Path by argument().path()
    val VARIABLE_2: Path by argument().path().validate {
        require(it.toFile().exists()) { "ERROR: $it does not exist" }
    }
    val VARIABLE_3: String by argument()
    val VARIABLE_4: String by argument()
    val AWS_REGION: String by argument()
    val VARIABLE_5: List<String> by argument().multiple()

    override fun run() {
        // TODO
    }
}
