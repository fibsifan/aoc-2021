class Day01: Day() {
    override fun part1(): Long {
        val intInput = input.map { it.toLong() }
        return intInput.subList(0, intInput.size-1)
            .zip(intInput.subList(1, intInput.size))
            .map { if (it.first < it.second) 1L else 0L }
            .sum()
    }


    override fun part2(): Long {
        val intInput = input.map { it.toLong() }
        return intInput.windowed(4,1) {
            if (it.subList(0,2).sum() < it.subList(1,3).sum()) 1L else 0L
        }.sum()
    }
}

fun main() {
    Day01().run()
}
