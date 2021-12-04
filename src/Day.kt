import java.io.File

abstract class Day {
    val input: List<String> = File("src", "${this::class.simpleName}.txt").readLines()

    abstract fun part1(): Int
    abstract fun part2(): Int
    fun run() {
        println(part1())
        println(part2())
    }
}