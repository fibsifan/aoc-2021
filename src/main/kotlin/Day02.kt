class Day02: Day() {
    val preparedInput = input.map {
        val split = it.split(" ")
        Pair(split[0], split[1].toLong())
    }

    override fun part1(): Long {
        val hor = preparedInput.filter { "forward".equals(it.first) }
            .map {it.second }.sum()
        val depth = preparedInput.filter { "down".equals(it.first) }
            .map {it.second}.sum() -  preparedInput.filter { "up".equals(it.first) }
            .map {it.second}.sum()
        return hor * depth
    }

    override fun part2(): Long {
        val aims = preparedInput.runningFold(0L) {
                aim,
                pair ->
            if ("down".equals(pair.first)) aim + pair.second
            else if ("up".equals(pair.first)) aim - pair.second
            else aim
        }
        val depthHor = preparedInput.foldIndexed(Pair(0L,0L)) {
                index, depthHor, currentInput ->
            if("forward".equals(currentInput.first))
                Pair(depthHor.first + aims[index]*currentInput.second,
                    depthHor.second+currentInput.second)
            else
                depthHor
        }
        return depthHor.first*depthHor.second
    }
}

fun main() {
    Day02().run()
}
