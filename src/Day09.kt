fun main() {

    fun getSum(input: List<String>, first:Boolean): Int {
        return input
            .map { it.split(' ').map { s -> s.toInt() } }
            .sumOf { it.getNextElement(first) }
    }

    fun part1(input: List<String>): Int {
        return getSum(input,false)
    }

    fun part2(input: List<String>): Int {
        return getSum(input,true)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day09_test")
    check(part1(testInput) == 114)

    check(part2(testInput) == 2)

    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}

private fun List<Int>.getNextElement(first:Boolean): Int {
    return if (this.groupBy { it }.size == 1) this[0]
    else {
        val nextElement = this.windowed(2).map { it[1] - it[0] }.getNextElement(first)
        if (first) this.first() - nextElement
        else this.last() + nextElement
    }
}
