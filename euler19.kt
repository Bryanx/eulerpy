fun main() {
    var result = 0
    for (year in 1901..2000)
        for (month in 1..12)
            if (LocalDate.of(year, month, 1).dayOfWeek == DayOfWeek.SUNDAY)
                result++
    print("Result: $result")
}