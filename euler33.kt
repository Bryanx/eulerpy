/*

The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value,
and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

 */

val zeroAscii = '0'.toInt()

fun main() {
    var numerators = 1
    var denominators = 1
    for (i in 12 until 99) {
        for (j in 12 until 99) {
            if (j < i || i % 11 == 0 || j % 11 == 0) continue
            if (i.toString().last() == j.toString().first()) {
                var newI = i.toString().first().toInt() - zeroAscii
                var newJ = j.toString().last().toInt() - zeroAscii
                if (newJ.toDouble() / newI == j.toDouble() / i) {
                    println("$i/$j = $newI/$newJ")
                    numerators *= newI
                    denominators *= newJ
                }
            }
        }
    }
    println("total:")
    println("$numerators/$denominators")
}