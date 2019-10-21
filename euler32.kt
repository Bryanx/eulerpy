/*

We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

 */

fun main() {
    val set = mutableSetOf<Int>()
    (1..5000).forEach { i ->
        (1..5000).asSequence()
                .filter { isPanDigital("$i$it${(i * it)}") }
                .forEach { set += i * it }
    }
    println("${set.sum()}")
}

fun isPanDigital(str: String): Boolean {
    if (str.length != 9) return false
    if (str.contains('0')) return false
    for (i in 0..str.length) {
        for (j in i + 1 until str.length) {
            if (str[i] === str[j]) {
                return false
            }
        }
    }
    return true
}