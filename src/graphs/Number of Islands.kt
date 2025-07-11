package graphs

/*
    Leetcode: https://leetcode.com/problems/number-of-islands/
    Neetcode: https://neetcode.io/problems/count-number-of-islands?list=neetcode150
 */

fun numIslands(grid: Array<CharArray>): Int {

    val direction = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
    )
    val rows = grid.size
    val cols = grid[0].size
    var islands = 0

    val visited = Array(rows) {
        BooleanArray(cols) { false }
    }

    fun dfs(row: Int, col: Int) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0' || visited[row][col]) {
            return
        }
        visited[row][col] = true
        direction.forEach {
            dfs(row + it[0], col + it[1])
        }
    }

    grid.forEachIndexed { row, value ->
        value.forEachIndexed { col, ch ->
            if (grid[row][col] == '1' && !visited[row][col]) {
                dfs(row, col)
                islands++
            }
        }
    }

    return islands
}