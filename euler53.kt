import java.math.BigDecimal

/**
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 */

fun main() {
    (1..100).map { n ->
        (1..n).filter { r -> fact(n) / (fact(r) * fact(n - r)) > 1000000.toBigDecimal() }
                .count()
    }.sum().also(::print)
}

fun fact(i: Int, n: BigDecimal = 1.toBigDecimal()): BigDecimal = when (i) {
    0 -> n
    else -> fact(i - 1, n * i.toBigDecimal())
}