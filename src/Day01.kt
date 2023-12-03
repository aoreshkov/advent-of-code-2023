fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { 10 * (it.first { c -> c.isDigit() }.code - '0'.code) + it.last { c -> c.isDigit() }.code - '0'.code }
            .sumOf { it }
    }

    fun part2(input: List<String>): Int {
        val digits = arrayOf("1","2","3","4","5","6","7","8","9","0"
            ,"one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
            .mapIndexed { index, s -> ((index + 1) % 10) to s }
        return input
            .map {str ->
                10 * digits.map { it.first to str.indexOf(it.second) }.filter { it.second != -1 }.minWith(compareBy { it.second}).first +
                        digits.maxWith(compareBy { str.lastIndexOf(it.second) }).first
            }
            .sumOf { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
