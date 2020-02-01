package at.stnwtr.sudokusolver

class Sudoku(private val board: Array<IntArray>) {

    fun solve(): Boolean {
        val position = findEmpty() ?: return true

        for (i in 1..9) {
            if (isValid(i, position)) {
                board[position.first][position.second] = i

                if (solve()) return true else board[position.first][position.second] = 0
            }
        }

        return false
    }

    private fun findEmpty(): Pair<Int, Int>? {
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] == 0) {
                    return i to j
                }
            }
        }

        return null
    }

    private fun isValid(value: Int, position: Pair<Int, Int>): Boolean {
        if (value in board[position.first]) {
            return false
        }

        for (i in 0..8) {
            if (board[i][position.second] == value) {
                return false
            }
        }

        for (i in 0..2) {
            for (j in 0..2) {
                if (board[position.first / 3 * 3 + i][position.second / 3 * 3 + j] == value) {
                    return false
                }
            }
        }

        return true
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        for (i in 0..8) {
            if (i % 3 == 0 && i != 0) {
                stringBuilder.append("---------+-----------+---------${System.lineSeparator()}")
            }

            for (j in 0..8) {
                if (j % 3 == 0 && j != 0) {
                    stringBuilder.append("|  ")
                }

                stringBuilder.append("${board[i][j]}  ")
            }
            stringBuilder.append(System.lineSeparator())
        }

        return stringBuilder.trimEnd().toString()
    }

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass == other?.javaClass -> true
        other is Sudoku -> board contentDeepEquals other.board
        else -> false
    }

    override fun hashCode() = board.contentDeepHashCode()
}
