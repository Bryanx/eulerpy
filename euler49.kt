/*

The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
(i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

 */

fun main() = getPrimes(10000).forEach { primePermutations(it) }

fun primePermutations(n: Int) {
    val perms = permutations(n.toString()).map { it.toInt() }
    if (perms.count() < 3 || perms.contains(1487)) return
    for (i in perms) {
        for (j in perms) {
            for (k in perms) {
                if (j - i > 0 && j - i == k - j)
                    println("[$i, $j, $k] = diff(${j - i})")
            }
        }
    }
}

fun permutations(str: String, prefix: String = "", perms: MutableSet<String> = mutableSetOf()): Set<String> {
    if (str.isEmpty() && isPrime(prefix.toInt()) && prefix.first() != '0') perms.add(prefix)
    for (i in 0 until str.length)
        permutations(str.substring(0, i) + str.substring(i + 1, str.length), prefix + str[i], perms)
    return perms.toSet()
}

fun getPrimes(limit: Int): List<Int> = (2..limit).filter(::isPrime).filter { it in 1000..limit }

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()