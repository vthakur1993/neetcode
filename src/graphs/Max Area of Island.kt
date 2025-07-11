package graphs

import kotlin.math.max

/*
    Leetcode: https://leetcode.com/problems/max-area-of-island/description/
    Neetcode: https://neetcode.io/problems/max-area-of-island?list=neetcode150
 */

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val direction = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )
    val rows = grid.size
    val cols = grid[0].size

    val visited = Array(rows) {
        BooleanArray(cols) { false }
    }

    fun dfs(row: Int, col: Int): Int {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0 || visited[row][col]) {
            return 0
        }
        visited[row][col] = true
        var area = 0
        direction.forEach {
            area += dfs(row + it[0], col + it[1])
        }

        return area + 1
    }

    var maxArea = 0

    grid.forEachIndexed { row, list ->
        list.forEachIndexed { col, value ->
            if (grid[row][col] == 1 && !visited[row][col]) {
                maxArea = max(maxArea, dfs(row,col))
            }
        }
    }
    return maxArea
}