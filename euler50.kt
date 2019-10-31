/*

The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

 */

fun main() {
    val primes = getPrimes(1000000)
    (2..primes.size)
            .map { getLargestPrimeSum(primes.subList(it, primes.size)) }
            .also { print(it.maxBy { it.size }?.sum()) }
}

fun getLargestPrimeSum(primes: List<Int>): List<Int> {
    var largestPrimeSum = listOf(0)
    (2..primes.size).forEach { i ->
        val sum = primes.subList(0, i)
        if (isPrime(sum.sum()) && sum.size > largestPrimeSum.size) largestPrimeSum = sum
        if (sum.sum() > 1000000) return largestPrimeSum
    }
    return largestPrimeSum
}

fun getPrimes(limit: Int): List<Int> = (2..limit).filter(::isPrime).filter { it < limit }

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()