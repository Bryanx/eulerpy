fun main() {
    var n = 10000
    var map = mutableMapOf<Int, Int>()
    // gets the divisorsum for each number and adds it to the map.
    for (i in 1..n) {
        var res = divisorSum(i)
        map[i] = res
    }
    // removes the pair if there is no pair in the map with the same key-value.
    for (i in 1..n) {
        var isAmicable = false
        for (keyI in 1..n) {
            if (keyI != i && // if the key is not the same as current
                    map[keyI] == i &&  // if the value is the same as key.
                    keyI == map[i]  // if the key is the same as value.
            ) {
                isAmicable = true
            }
        }
        if (!isAmicable)
            map.remove(i)
    }

    // get the sum of all distinct values
    var sum = 0
    var tst = mutableListOf<Int>()
    for (i in 1..n) {
        if (map[i] != null && ! tst.contains(map[i])) {
            tst.add(i)
            print("$i = ${map[i]}\n")
            sum += i + map[i]!!
        }
    }
    print("result = $sum")
}

fun divisorSum(n: Int): Int {
    var sum = 0
    for (i in 1 until n) {
        if (n % i == 0) sum += i
    }
    return sum
}
