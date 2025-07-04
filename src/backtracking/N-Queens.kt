package backtracking

/*
    LeetCode: https://leetcode.com/problems/n-queens/submissions/1685879681/
    NeetCoee: https://neetcode.io/problems/n-queens?list=neetcode150
*/

fun solveNQueens(n: Int): List<List<String>> {
    val matrix = MutableList(n) { // Creates the outer list of size n
        MutableList(n) { '.' }     // For each row, creates an inner list of size n, initialized with '.
    }
    val result = mutableListOf<List<String>>()

    fun isQueenValid(row: Int, col: Int): Boolean {
        if (row == 0) return true

        var currRow = row - 1

        while (currRow >= 0) {
            if (matrix[currRow][col] == 'Q') {
                return false
            }
            currRow--
        }

        currRow = row - 1
        var currCol = col - 1
        while (currRow >= 0 && currCol >= 0) {
            if (matrix[currRow][currCol] == 'Q') {
                return false
            }
            currRow--
            currCol--
        }
        currRow = row - 1
        currCol = col + 1
        while (currRow >= 0 && currCol < n) {
            if (matrix[currRow][currCol] == 'Q') {
                return false
            }
            currRow--
            currCol++
        }
        return true
    }

    fun dfs(row: Int) {
        val list = mutableListOf<String>()
        if (row >= n) {
            val list = mutableListOf<String>()
            matrix.forEach {
                list.add(it.joinToString(separator = ""))
            }
            result.add(list)
        }

        repeat(n) {
            if(isQueenValid(row, it)) {
                matrix[row][it] = 'Q'
                dfs(row + 1)
                matrix[row][it] = '.'
            }
        }
    }

    dfs(0)
    return result
}