class Day01: Day() {
    override fun part1(): Int {
        val intInput = input.map { it.toInt() }
        return intInput.subList(0, intInput.size-1)
            .zip(intInput.subList(1, intInput.size))
            .map { if (it.first < it.second) 1 else 0 }
            .sum()
    }


    override fun part2(): Int {
        val intInput = input.map { it.toInt() }
        return intInput.windowed(4,1) {
            if (it.subList(0,2).sum() < it.subList(1,3).sum()) 1 else 0
        }.sum()
    }
}

fun main() {
    Day01().run()
}
