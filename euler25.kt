var phi = ((1 + Math.sqrt(5.0)) / 2).toBigDecimal()

fun main() {
    var n = 3
    var temp2 = BigInteger.valueOf(3)
    while (temp2.toString().length < 1000) {
        val t = (temp2.toBigDecimal() * phi)
        temp2 = t.round(MathContext(0)).toBigInteger()
        n++
    }
    println("$n")
}