package graphs

/*
    Leetcode: https://leetcode.com/problems/pacific-atlantic-water-flow/
    Neetcode: https://neetcode.io/problems/pacific-atlantic-water-flow?list=neetcode150
 */

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val rows = heights.size
    val cols = heights[0].size
    val result = mutableListOf<List<Int>>()
    val pac = HashSet<Pair<Int,Int>>()
    val atl = HashSet<Pair<Int,Int>>()

    fun dfs(r: Int, c: Int, visit: HashSet<Pair<Int,Int>>, prevHeight: Int) {
        val coord = r to c
        if (coord in visit ||
            r < 0 || c < 0 ||
            r == rows || c == cols ||
            heights[r][c] < prevHeight
        ) {
            return
        }

        visit.add(coord)

        dfs(r + 1, c, visit, heights[r][c])
        dfs(r - 1, c, visit, heights[r][c])
        dfs(r, c + 1, visit, heights[r][c])
        dfs(r, c - 1, visit, heights[r][c])
    }

    for (row in 0 until rows) {
        dfs(row, 0, pac, heights[row][0])
        dfs(row, cols - 1, atl, heights[row][cols - 1])
    }

    for (col in 0 until cols) {
        dfs(0, col, pac, heights[0][col])
        dfs(rows - 1, col, atl, heights[rows - 1][col])
    }

    for (row in 0 until rows) {
        for (col in 0 until cols) {
            val cord = (row to col)
            if (cord in pac && cord in atl) {
                result.add(listOf(row, col))
            }
        }
    }

    return result
}