import java.math.BigDecimal

/**
 *
 * There are exactly ten ways of selecting three from five, 12345:
* 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
* In combinatorics, we use the notation, (5 choose 3)=10.
* In general, (n choose r)=n!r!/(n−r)!, where r≤n, n!=n×(n−1)×...×3×2×1, and 0!=1.
* It is not until n=23, that a value exceeds one-million: (23 choose 10)=1144066.
* How many, not necessarily distinct, values of (n choose r) for 1≤n≤100, are greater than one-million?
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