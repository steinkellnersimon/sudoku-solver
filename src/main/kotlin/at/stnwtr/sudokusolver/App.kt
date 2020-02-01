package at.stnwtr.sudokusolver

fun main() {
    val board = arrayOf(
        intArrayOf(4, 0, 8, 0, 7, 0, 0, 5, 2),
        intArrayOf(0, 0, 0, 9, 0, 0, 1, 0, 7),
        intArrayOf(0, 0, 6, 0, 0, 0, 8, 0, 0),
        intArrayOf(0, 0, 0, 0, 5, 0, 0, 0, 6),
        intArrayOf(5, 0, 4, 0, 0, 0, 0, 0, 8),
        intArrayOf(0, 8, 0, 2, 0, 7, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(9, 0, 0, 0, 0, 0, 3, 0, 0),
        intArrayOf(0, 2, 1, 3, 0, 5, 9, 0, 0)
    )

    val sudoku = Sudoku(board)

    println(sudoku)
    println("~".repeat(31))
    sudoku.solve()
    println(sudoku)
}
