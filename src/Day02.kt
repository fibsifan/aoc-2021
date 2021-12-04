class Day02: Day() {
    val preparedInput = input.map {
        val split = it.split(" ")
        Pair(split[0], split[1].toInt())
    }

    override fun part1(): Int {
        val hor = preparedInput.filter { "forward".equals(it.first) }
            .map {it.second }.sum()
        val depth = preparedInput.filter { "down".equals(it.first) }
            .map {it.second}.sum() -  preparedInput.filter { "up".equals(it.first) }
            .map {it.second}.sum()
        return hor * depth
    }

    override fun part2(): Int {
        val aims = preparedInput.runningFold(0) {
                aim,
                pair ->
            if ("down".equals(pair.first)) aim + pair.second
            else if ("up".equals(pair.first)) aim - pair.second
            else aim
        }
        val depthHor = preparedInput.foldIndexed(Pair(0,0)) {
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