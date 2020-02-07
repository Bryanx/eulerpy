/**
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 */

fun main() {
    (1..200000).first { i -> (2..6).all { i.sorted() == (i * it).sorted() } }
            .also(::print)
}

private fun Int.sorted() = this.toString().toCharArray().sorted()
