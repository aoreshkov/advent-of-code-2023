import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {

    fun getWins(time:Long, distance:Long):Long {
        val d = sqrt((time * time - 4 * distance).toDouble())
        return  ceil((time + d) / 2).toLong() - ((time - d) / 2).toLong() - 1
    }

    fun part1(input: List<String>): Long {
        val times = input[0].substring(10).split(' ').filter { it.isNotEmpty() }.map { it.toLong() }
        val distances = input[1].substring(10).split(' ').filter { it.isNotEmpty() }.map { it.toLong() }

        return times.foldIndexed(1) { i, s, t ->
            s * getWins(t, distances[i])
        }
    }

    fun part2(input: List<String>): Long {
        val time = input[0].substring(10).replace(" ", "").toLong()
        val distance = input[1].substring(10).replace(" ", "").toLong()

        return getWins(time, distance)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 288L)
    check(part2(testInput) == 71503L)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
