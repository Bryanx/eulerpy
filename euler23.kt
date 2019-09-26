fun main() {
    var lst = (0..28123).toMutableList()

    // first filter all abundant numbers
    // then get  the sum of all abundant numbers and remove them from the list.
    lst.filter { divisorSum(it) > it }.apply {
        for (i in this)
            for (j in this.filter { i + it < lst.size })
                lst[i + j] = 0
    }

    print("result = ${lst.sum()}")
}

fun divisorSum(limit: Int) = (1 until limit).filter { limit % it == 0 }.sum()