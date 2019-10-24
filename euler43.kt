/*

The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order,
but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4 = 406 is divisible by 2
d3d4d5 = 063 is divisible by 3
d4d5d6 = 635 is divisible by 5
d5d6d7 = 357 is divisible by 7
d6d7d8 = 572 is divisible by 11
d7d8d9 = 728 is divisible by 13
d8d9d10 = 289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.

 */
val list = listOf(2, 3, 5, 7, 11, 13, 17)

fun main() {
    permutations("1406357289")
            .filter { it[0] != '0' }
            .filter { (1..7).all { i -> it.substring(i, i + 3).toInt() % list[i - 1] == 0 } }
            .map { it.toBigInteger() }
            .also { print("${it.reduce { acc, i -> acc + i }}") }
}

fun permutations(str: String, prefix: String = "", perms: MutableSet<String> = mutableSetOf()): MutableSet<String> {
    if (str.isEmpty() && isPanDigital(prefix)) perms.add(prefix)
    for (i in 0 until str.length)
        permutations(str.substring(0, i) + str.substring(i + 1, str.length), prefix + str[i], perms)
    return perms
}

fun isPanDigital(str: String): Boolean {
    val chars = "0123456789".substring(0, str.length).toMutableList()
    return str.all { chars.remove(it) }
}