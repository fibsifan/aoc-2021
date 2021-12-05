class Day04: Day() {
    val randomNumbers = input[0].split(",").map {it.toInt()}
    val boards = input.subList(1, input.size)
        .chunked(6)
        .map{parseBoard(it)}

    override fun part1(): Int {
        for ((index, randomNumber) in randomNumbers.withIndex()) {
            boards.forEach { it.check(randomNumber) }
            if (index > 5) {
                val winningBoards = boards.filter { it.hasWon() }
                if (winningBoards.size > 0) {
                    return winningBoards[0].sum * randomNumber
                }
            }
        }
        TODO("What if we get here?")
    }

    override fun part2(): Int {
        val boardsInTheGame = boards.toMutableList()
        for ((index, randomNumber) in randomNumbers.withIndex()) {
            boards.forEach { it.check(randomNumber) }
            if (index > 5) {
                if (boardsInTheGame.size > 1) {
                    val winningBoards = boards.filter { it.hasWon() }
                    boardsInTheGame.removeAll(winningBoards)
                } else if (boardsInTheGame[0].hasWon()) {
                    return boardsInTheGame[0].sum * randomNumber
                }
            }
        }
        TODO("What if we get here?")
    }

    private fun parseBoard(lines: List<String>): Board {
        check(lines.size==6)
        check(lines[0].isBlank())
        return Board(lines.subList(1, lines.size))
    }
}

class Board(text: List<String>) {
    val rowHitCounts = mutableListOf(0, 0, 0, 0, 0)
    val colHitCounts = mutableListOf(0, 0, 0, 0, 0)
    val board = createBoardMap(text)
    var sum = 0

    private fun createBoardMap(text: List<String>): MutableMap<Int, Pair<Int, Int>> {
        val board = mutableMapOf<Int, Pair<Int,Int>>()
        for ((i, line) in text.withIndex()) {
            val chunkedLine = line.chunked(3) { it.trim().toString() }
            for ((j, number) in chunkedLine.map { it.toInt() }.withIndex()) {
                board.put(number, Pair(i, j))
                sum += number
            }
        }
        return board
    }

    fun check(number: Int) {
        if (board.containsKey(number)) {
            rowHitCounts[board.get(number)!!.first] +=1
            colHitCounts[board.get(number)!!.second] += 1
            sum -= number
            board.remove(number)
        }
    }

    fun hasWon(): Boolean {
        return rowHitCounts.any { it == 5 } || colHitCounts.any { it == 5}
    }
}

fun main() {
    Day04().run()
}