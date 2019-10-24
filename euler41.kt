/*

We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.
What is the largest n-digit pandigital prime that exists?

 */

fun main() {
    permutations("7654321").first { isPanDigital(it) && isPrime(it.toInt()) }
            .also(::print)
}

fun permutations(str: String, prefix: String="", perms: MutableSet<String> = mutableSetOf()): MutableSet<String> {
    if (str.isEmpty()) perms.add(prefix)
    for (i in 0 until str.length)
        permutations( str.substring(0, i) + str.substring(i + 1, str.length), prefix + str[i], perms)
    return perms
}

fun isPanDigital(str: String): Boolean {
    val chars = "123456789".substring(0, str.length).toMutableList()
    return !str.contains('0') && str.all { chars.remove(it) }
}

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()