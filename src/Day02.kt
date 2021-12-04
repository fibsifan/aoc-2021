
fun main() {
    fun prepareInput(input: List<String>): List<Pair<String, Int>> {
        return input.map {
            val split = it.split(" ")
            Pair(split[0], split[1].toInt())
        }
    }

    fun part1(input: List<String>): Int {
        val preparedInput = prepareInput(input)
        val hor = preparedInput.filter { "forward".equals(it.first) }
            .map {it.second }.sum()
        val depth = preparedInput.filter { "down".equals(it.first) }
            .map {it.second}.sum() -  preparedInput.filter { "up".equals(it.first) }
            .map {it.second}.sum()
        return hor * depth
    }

    fun part2(input: List<String>): Int {
        val preparedInput = prepareInput(input)
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

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}