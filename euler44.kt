/*

Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:

1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...

It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.

Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal
and D = |Pk − Pj| is minimised; what is the value of D?

 */

fun main() {
    val pentagonals = (1..10000).map { it * (3 * it - 1) / 2 }
    for (i in pentagonals) {
        for (j in pentagonals) {
            if (pentagonals.contains(i + j) && pentagonals.contains(j - i)) {
                println("${j - i}")
                return
            }
        }
    }
}