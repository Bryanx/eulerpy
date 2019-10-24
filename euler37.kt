/*

The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

 */

fun main() {
    getPrimes(1000000)
            .filter { (isTruncatablePrime(it.toString())) }
            .also { println(it.sum()) }
}

fun isTruncatablePrime(n: String): Boolean =
        (1 until n.length).all { isPrime(n.substring(it).toInt()) && isPrime(n.substring(0, it).toInt()) }

fun getPrimes(limit: Int): List<Int> = (8..limit).filter(::isPrime)

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 } && n != 1

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()