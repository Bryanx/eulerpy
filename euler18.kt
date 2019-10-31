/*

By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

(3)
(7) ,4
2 ,(4) ,6
8 ,5 ,(9) ,3

That is, 3 ,+ 7 ,+ 4 ,+ 9 ,= 23.

Find the maximum total from top to bottom of the triangle below:

*/

val pyramid = listOf(
        listOf(75),
        listOf(95, 64),
        listOf(17, 47, 82),
        listOf(18, 35, 87, 10),
        listOf(20, 4, 82, 47, 65),
        listOf(19, 1, 23, 75, 3, 34),
        listOf(88, 2, 77, 73, 7, 63, 67),
        listOf(99, 65, 4, 28, 6, 16, 70, 92),
        listOf(41, 41, 26, 56, 83, 40, 80, 70, 33),
        listOf(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
        listOf(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
        listOf(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
        listOf(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
        listOf(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
        listOf(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23)
)

var maxSum = 0

fun main() {
    recursiveLoop()
    println(maxSum)
}

fun recursiveLoop(sum: Int = 75, row: Int = 1, column: Int = 0) {
    if (row == pyramid.size) {
        if (sum > maxSum) maxSum = sum
        return
    }
    recursiveLoop(sum + pyramid[row][column], row + 1, column)
    recursiveLoop(sum + pyramid[row][column + 1], row + 1, column + 1)
}