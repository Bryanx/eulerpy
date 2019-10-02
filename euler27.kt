/*

Euler discovered the remarkable quadratic formula:

n^2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39. However,
when n=40,40^2+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,41^2+41+41 is clearly divisible by 41.

The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79.
The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:
n^2+a*n+b, where |a|<1000 and |b|≤1000
where |n| is the modulus/absolute value of n
e.g. |11|=11 and |−4|=4

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
primes for consecutive values of n, starting with n=0.

 */
fun main() {
    var primes = getPrimes(2000)
    var (maxA, maxB, maxN) = Triple(0,0,0)

    for (a in -1000..1000) {
        for (b in -1000..1000) {
            for (n in 0..1000) {
                var result = (n * n) + a * n + b
                if (!primes.contains(result)) {
                    if (n > maxN) {
                        maxA = a
                        maxB = b
                        maxN = n
                    }
                    break
                }
            }
        }
    }
    println("a:$maxA b:$maxB produces $maxN consecutive primes.")
    println("$maxA * $maxB = ${maxA*maxB}")
}

fun getPrimes(limit: Int): List<Int> = (2..limit).filter(::isPrime)

fun isPrime(n: Int): Boolean = (2..sqrt(n)).none { n % it == 0 }

fun sqrt(i: Int) = Math.sqrt(i.toDouble()).toInt()