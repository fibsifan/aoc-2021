fun main() {
    fun toIntArray(binary: String): List<Int> {
        return binary.chunked(1) .map { it.toInt() }
    }

    fun toDecimal(binary: List<Int>) = binary.map { it.toString() }.joinToString("").toInt(2)

    fun part1(input: List<String>): Int {
        val total = input.size

        val countOfOnes = input.map {toIntArray(it)}
            .reduce { sumOfOnes, nextOnes -> sumOfOnes.zip(nextOnes) {a, b -> a+b}}

        val gamma = countOfOnes.map { if (it > total/2) 1 else 0 }
        val epsilon = gamma.map{if (it == 1) 0  else 1}

        val gammaInt = toDecimal(gamma)
        val epsilonInt = toDecimal(epsilon)

        return gammaInt * epsilonInt
    }

    fun part2(input: List<String>): Int {
        var o2Remaining = input
        for (i in input[0].indices) {
            val countOfOnes = o2Remaining.map { it.substring(i,i+1).toInt() }.sum()
            val select = if (countOfOnes * 2 >= o2Remaining.size) "1" else "0"
            o2Remaining = o2Remaining.filter { it.substring(i,i+1).equals(select)}
            if (o2Remaining.size == 1) {
                break
            }
        }

        var co2Remaining = input
        for (i in input[0].indices) {
            val countOfOnes = co2Remaining.map { it.substring(i,i+1).toInt() }.sum()
            val select = if (countOfOnes * 2 < co2Remaining.size) "1" else "0"
            co2Remaining = co2Remaining.filter { it.substring(i,i+1).equals(select)}
            if (co2Remaining.size == 1) {
                break
            }
        }
        val o2Int = o2Remaining[0].toInt(2)
        val co2Int = co2Remaining[0].toInt(2)
        return o2Int * co2Int
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}