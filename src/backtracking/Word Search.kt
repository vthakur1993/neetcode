package backtracking

/*
    Leetcode: https://leetcode.com/problems/word-search/
    Neetcode: https://neetcode.io/problems/search-for-word?list=neetcode150
 */

fun exist(board: Array<CharArray>, word: String): Boolean {
    val visited = Array<BooleanArray>(board.size) {
        BooleanArray(board[0].size, { false } )
    }

    fun search(row: Int, col: Int, currWord: Int): Boolean {
        if (currWord == word.length) return true
        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size
            || word[currWord] != board[row][col] || visited[row][col]) return false

        visited[row][col] = true

        if (search(row + 1,col, currWord+1) ||
            search(row - 1,col, currWord+1) ||
            search(row,col + 1, currWord+1) ||
            search(row,col - 1, currWord+1)
        ) {
            return true
        }

        visited[row][col] = false
        return false
    }

    board.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, col ->
            if (search(rowIndex,colIndex, 0)) {
                return true
            }
        }
    }


    return false
}