/*

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
1p, 2p, 5p, 10p, 20p, 50p, 100, 200
It is possible to make £2 in the following way:
1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
How many different ways can £2 be made using any number of coins?

 */
var combos: MutableSet<List<Int>> = hashSetOf()

fun main() {
    countSums(listOf(1, 2, 5, 10, 20, 50, 100, 200))
    println("combos:${combos.map { it.sorted() }.distinct().size}")
}

fun countSums(coins: List<Int>, lst: List<Int> = listOf()) {
    var remainder = 200 - lst.sum()
    for (coin in coins) {
        var tempList = lst.toMutableList()
        // add the coin to a list if it can be added.
        for (i in 0 until remainder / coin) {
            tempList.add(coin)
            // after adding each coin, repeat the process to see if other coins can be added.
            countSums(coins.filter { it != coin && remainder % it == 0 }, tempList)
        }
        if (tempList.sum() == 200) combos.add(tempList)
    }
}