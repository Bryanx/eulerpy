/*

Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576.
We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed
as the concatenated product of an integer with (1,2, ... , n) where n > 1?

 */

fun main() {
    // only numbers between 9000 and 9999 * 2 result in 9 digits that start with a 9.
    (9000..9999)
            .reversed()
            .map { "$it${(it * 2)}" }
            .first { it.length == 9 && isPanDigital(it) }
            .also(::print)
}

fun isPanDigital(str: String): Boolean {
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
