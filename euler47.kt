/*

The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

 */
var primes = getPrimes(1000) + getPrimes(1000).map { it*it }.filter { it < 1000 }
val lst = mutableListOf<Int>()

fun main() {
    for (i in 2..200000) {
        getDistincPrimeFactors(i)
    }
}

fun getDistincPrimeFactors(i: Int) {
    var tempPrimes = primes.filter { i % it == 0 }
    for (j in tempPrimes) for (k in tempPrimes) for (l in tempPrimes) for (m in tempPrimes) {
        if (j == k || j == l || l == k || j == m || m == k || m == l) continue
        if (listOf(j, k, l, m).contains(4) && listOf(j, k, l, m).contains(2)) continue
        if (i == j * k * l * m) {
            if (lst.size > 3 && lst[lst.size-1] == i - 1 && lst[lst.size-2] == i - 2 && lst[lst.size-3] == i - 3)
                println("${i-3}")
            lst.add(i)
            return
        }
    }
}

fun getPrimes(limit: Int): List<Int> = (2..limit).filter(::isPrime)

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()