package arrays

/*
    Leetcode: https://leetcode.com/problems/valid-sudoku/
    Neetcode: https://neetcode.io/problems/valid-sudoku?list=neetcode150
 */

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = Array(9) { HashSet<Char>() }
    val cols = Array(9) { HashSet<Char>() }
    val squares = Array(9) { HashSet<Char>() }

    for (r in 0 until 9) {
        for (c in 0 until 9) {
            val value = board[r][c]
            if (value == '.') continue

            val squareIdx = (r / 3) * 3 + (c / 3)
            if (value in rows[r] || value in cols[c] ||
                value in squares[squareIdx]) {
                return false
            }

            rows[r].add(value)
            cols[c].add(value)
            squares[squareIdx].add(value)
        }
    }

    return true
}