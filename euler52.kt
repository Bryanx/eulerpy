/**
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 */

fun main() {
    val numbers = listOf(2,3,4,5,6)
    (1..200000)
            .first { i -> numbers.all { containsSameDigits(i, i * it) } }
            .also(::print)
}

fun containsSameDigits(n1: Int, n2: Int): Boolean {
    val s1 = n1.toString()
    val s2 = n2.toString()
    return s1.length == s2.length && s1.all { s2.contains(it) }
}
