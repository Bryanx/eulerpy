/*

145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
Find the sum of all numbers which are equal to the sum of the factorial of their digits.
Note: as 1! = 1 and 2! = 2 are not sums they are not included.

 */

fun main() {
    (3..10000000)
            .filter { it.toString().map { fact(it.toInt() - '0'.toInt()) }.sum() == it }
            .also { print(it.sum()) }
}

fun fact(i: Int, n: Int = 1): Int = if (i == 0) n else fact(i - 1, n * i)