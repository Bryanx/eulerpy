import kotlin.math.sqrt

/*

If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

 */

fun main() {
    (1 until 1000)
            .map { getSolutions(it.toDouble()) }
            .also { print(it.indexOf(it.max()) + 1) }
}

fun getSolutions(desiredP: Double): Int {
    var count = 0
    for (a in (1.0..desiredP / 2).step(1.0)) {
        for (b in (1.0..desiredP / 4).step(1.0)) {
            if (a + b + sqrt(a * a + b * b) == desiredP) {
                count++
            }
        }
    }
    return count
}




// utility function
infix fun ClosedRange<Double>.step(step: Double): Iterable<Double> {
    require(start.isFinite())
    require(endInclusive.isFinite())
    require(step > 0.0) { "Step must be positive, was: $step." }
    val sequence = generateSequence(start) { previous ->
        if (previous == Double.POSITIVE_INFINITY) return@generateSequence null
        val next = previous + step
        if (next > endInclusive) null else next
    }
    return sequence.asIterable()
}