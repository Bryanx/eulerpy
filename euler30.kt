import kotlin.math.pow

/*

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

 */

var exponent = 5
var quads = (0..9).map{ it.pow(exponent) }

fun main() = println("Total: ${getSums(quads).sum() - 1}")

// recursive brute force solution
fun getSums(results: List<Int>, sums: List<Int> = listOf(), depth: Int = 6): List<Int> {
    if (depth <= 0) return sums.distinct()
    val newResults = results.flatMap { quads.map { q -> it + q } }
    val newSums = results.filter { it == it.toString().map { it.toString().toInt().pow(exponent) }.sum() }
    return getSums(newResults, newSums, depth - 1 )
}

infix fun Int.pow(exponent: Int): Int = toDouble().pow(exponent).toInt()