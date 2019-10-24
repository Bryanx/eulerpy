/*

The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?

 */

fun main() {
    getPrimes(1000000)
            .filter { (getRotations(it.toString()).all(::isPrime)) }
            .also { print(it.count()) }
}

fun getRotations(prime: String, set: List<Int> = listOf()): List<Int> {
    if (set.size == prime.length) return set
    return getRotations(rotate(prime), set + prime.toInt())
}

fun rotate(prime: String): String {
    val str = prime.toMutableList().also { it.add(it[0]) }
    for (i in 1 until str.size) str[i - 1] = str[i]
    return str.also { it.removeAt(str.lastIndex) }.joinToString("")
}

fun getPrimes(limit: Int): List<Int> = (2..limit).filter(::isPrime)

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()