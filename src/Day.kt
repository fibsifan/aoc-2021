import java.io.File

abstract class Day(val test: Boolean = false, val expected1: Int = 0, val expected2: Int = 0) {
    val input: List<String> = File("src", "${this::class.simpleName}${if (test) "_test" else ""}.txt")
        .readLines()

    abstract fun part1(): Int
    abstract fun part2(): Int
    fun run() {
        println(part1())
        println(part2())
        if (test) {
            check(expected1 == part1())
            check(expected2 == part2())
        }
    }
}