import kotlin.math.abs

class Day05(test: Boolean = false, expected1: Long = 0L, expected2: Long = 0L): Day(test, expected1, expected2) {
    private val ventLines = input.map{ parseVentLine(it)}

    override fun part1(): Long {
        return ventLines.filter { !it.diagonal }
            .flatMap { it.getPoints() }
            .groupingBy { it }
            .eachCount()
            .filter {it.value > 1}
            .size
            .toLong()
    }

    override fun part2(): Long {
        return ventLines
            .flatMap { it.getPoints() }
            .groupingBy { it }
            .eachCount()
            .filter {it.value > 1}
            .size
            .toLong()
    }

    fun parseVentLine(text: String): VentLine {
        val (start, end) = text.split(" -> ")
            .map { it.split(",").map{it.toInt()} }
            .map { Point(it[0], it[1]) }
        return VentLine(start, end)
    }
}

data class Point(val x: Int, val y: Int)

data class VentLine(val start: Point, val end: Point) {
    val diagonal = (start.x != end.x) && (start.y != end.y)

    fun getPoints(): List<Point> {
        val x = if (start.x < end.x)
            start.x..end.x
        else if (start.x > end.x)
            start.x downTo end.x
        else // start.x == end.x
            List(abs(end.y-start.y)+1, {start.x})

        val y = if (start.y < end.y)
            start.y..end.y
        else if (start.y > end.y)
            start.y downTo end.y
        else // start.y == end.y
            List(abs(end.x-start.x)+1, {start.y})

        return x.zip(y) { xv, yv -> Point(xv, yv)}
    }
}

fun main() {
    Day05().run()
}