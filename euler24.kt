import java.lang.Math.abs

// reverse through the amount of numbers and calculate factorial for each number.
// the factorial is the amount of times the number exists in all the permutations.
// for example in [0,1,2,3] the number 0 comes 3! = 6 times in the first position of all permutations
// requestedIndex/factorial = the amount of times the number exists in the result.
// subtract the result * the factorial from the requested index to know the remainder
// repeat.

fun main() {
    println(lexicograpicOrder1((0..9).toMutableList(), 1000000 - 1))
    println(lexicograpicOrder2((0..9).toMutableList(), 1000000 - 1))
    println(lexicograpicOrder3((0..9).toMutableList(), 1000000))
}

// recursive solution that uses a counter (n) that reorders the original list
fun lexicograpicOrder1(list: MutableList<Int>, i: Int, n: Int = 9): String {
    if (n == 0) return list.toString()
    val fac = fac(n)
    list.add(abs(n-9), list.removeAt(i / fac + abs(n-9)))
    return lexicograpicOrder1(list, i - i / fac * fac, n - 1)
}

// recursive solution that uses a separate result list
fun lexicograpicOrder2(list: MutableList<Int>, i: Int, result: MutableList<Int> = mutableListOf()): String {
    if (list.size == 0) return result.toString()
    val fac = fac(list.lastIndex)
    result += list.removeAt(i / fac)
    return lexicograpicOrder2(list, i - i / fac * fac, result)
}

// straight forward solution
fun lexicograpicOrder3(list: MutableList<Int>, i: Int = 0): String {
    var i = i - 1
    val numbers = list
    val result = mutableListOf<Int>()
    ((numbers.size - 1) downTo 0).map { fac(it) }.forEach { fac ->
        result.add(numbers.removeAt(i / fac))
        i -= i / fac * fac
    }
    return result.toString()
}

fun fac(n: Int): Int = if (n == 0) 1 else n * fac((n - 1))
