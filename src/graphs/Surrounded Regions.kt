package graphs

/*
    Leetcode: https://leetcode.com/problems/surrounded-regions/
    Neetcode: https://neetcode.io/problems/surrounded-regions?list=neetcode150
 */

fun solve(board: Array<CharArray>) {
    val rows = board.size
    val cols = board[0].size

    fun capture(r: Int, c: Int) {

        if (r < 0 || c < 0 || r == rows ||
            c == cols || board[r][c] != 'O') {
            return
        }
        board[r][c] = 'T'
        capture(r + 1, c)
        capture(r - 1, c)
        capture(r, c + 1)
        capture(r, c - 1)
    }

    for (r in 0 until rows) {
        if (board[r][0] == 'O') {
            capture(r, 0)
        }
        if (board[r][cols - 1] == 'O') {
            capture(r, cols - 1)
        }
    }

    for (c in 0 until cols) {
        if (board[0][c] == 'O') {
            capture(0, c)
        }
        if (board[rows - 1][c] == 'O') {
            capture(rows - 1, c)
        }
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (board[r][c] == 'O') {
                board[r][c] = 'X'
            } else if (board[r][c] == 'T') {
                board[r][c] = 'O'
            }
        }
    }
}