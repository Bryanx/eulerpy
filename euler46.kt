import kotlin.math.pow

/*

It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2 (2)
15 = 7 + 2×2^2 (8)
21 = 3 + 2×3^2 (18)
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

 */
var primes: List<Int> = listOf()

fun main() {
    val limit = 10000
    val doubleSquares = (1..limit).map { 2 * it * it }.filter { it < limit }
    oddComposites(limit)
            .filter { !primes.any { prime -> doubleSquares.contains(it - prime) } }
            .also { print(it.first()) }
}

fun oddComposites(n: Int): List<Int> {
    val indices = Array(n) { true }
    (2..Math.sqrt(n.toDouble()).toInt()).forEach { i ->
        var j = i.toDouble().pow(2).toInt()
        while (j < n) {
            indices[j] = false
            j += i
        }
    }
    primes = indices.mapIndexed { i, v -> if (v) i else -1 }.filter { it != -1 }
    return indices.mapIndexed { i, v -> if (!v) i else -1 }.filter { it != -1 && it % 2 != 0 }
}