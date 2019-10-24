/*

The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
(Please note that the palindromic number, in either base, may not include leading zeros.)

 */

fun main() {
    (0..1000000)
            .filter { isDoubleBasePalindrome(it) }
            .also { print(it.sum()) }
}

fun isDoubleBasePalindrome(i: Int): Boolean = isPalindrome(i.toString()) && isPalindrome(i.toString(2))

fun isPalindrome(i: String): Boolean = i == i.reversed()
