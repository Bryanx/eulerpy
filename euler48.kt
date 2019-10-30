/*

The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

 */

fun main() {
    (1..1000).map { it.toBigInteger().pow(it) }
            .reduce { a, b -> a + b }
            .also { println(it.toString().takeLast(10)) }
}