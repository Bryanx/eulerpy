import java.math.RoundingMode

fun main() {
    // loop through all possible i's
    (1..1000).forEach { i ->
        // divide 1 by i
        var result = 1.toBigDecimal().divide(i.toBigDecimal(), 2001, RoundingMode.HALF_UP)
        // prevent counting the leading 0's in the first decimal positions:
        if (i > 10) result = result.multiply(10.toBigDecimal())
        if (i > 100) result = result.multiply(10.toBigDecimal())

        for (n in 1..1000) {
            //convert result to a string
            val res = result.toString().substring(2, result.toString().length - 1)
            //try to find a pattern in the string by checking digit by digit if there is a pattern
            var hasPattern = res.substring(0, n).equals(res.substring(n, n + n))
            if (hasPattern) {
                if (res.substring(0, n).length > 950) {
                    println("$i = $n")
                }
                break
            }
        }
    }
}

