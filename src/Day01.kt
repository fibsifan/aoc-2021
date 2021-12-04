fun main() {
    fun part1(input: List<String>): Int {
        val intInput = input.map { it.toInt() }
        return intInput.subList(0, intInput.size-1)
            .zip(intInput.subList(1, intInput.size))
            .map { if (it.first < it.second) 1 else 0 }
            .sum()
    }

    fun part2(input: List<String>): Int {
        val intInput = input.map { it.toInt() }
        return intInput.windowed(4,1) {
            if (it.subList(0,2).sum() < it.subList(1,3).sum()) 1 else 0
        }.sum()
    }

    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
