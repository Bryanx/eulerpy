
fun main() {
    // use -64 (ascii value of A) to get the alphabet scores.
    File("assets/names.txt").readText()
            .split(",")
            .map { it.replace("\"", "") }
            .sorted()
            .mapIndexed { i, name -> name.sumBy { it.toInt() - 64 } * (i + 1) }
            .also { "total: ${scores.sum()}" }
}