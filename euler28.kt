import kotlin.math.pow
import kotlin.math.sqrt

/*

Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

3 5 7 9...

 */
fun main() {
    (3..1001 step 2).mapIndexed { i, v -> 4 * (v * v) - (i + 1) * 12 }
            .also { print(it.sum() + 1) }
}

// Previous solution refactored to above:
fun previousSolution() {
    var dim = 1001
    var topRight = (3..dim step 2).map { it * it }.sum() + 1
    var topLeft = (3..dim step 2).mapIndexed { i, it -> it * it - (i + 1) * 2 }.sum()
    var bottomLeft = (3..dim step 2).mapIndexed { i, it -> it * it - (i + 1) * 4 }.sum()
    var bottomRight = (3..dim step 2).mapIndexed { i, it -> it * it - (i + 1) * 6 }.sum()
    println(topRight + topLeft + bottomLeft + bottomRight)
}