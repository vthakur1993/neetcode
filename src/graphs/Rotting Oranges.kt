package graphs

import java.util.LinkedList

/*
    Leetcode: https://leetcode.com/problems/rotting-oranges/submissions/1695199545/
    NeetCode: https://neetcode.io/problems/rotting-fruit?list=neetcode150
 */

fun orangesRotting(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    val direction = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    val visited = Array(rows) {
        BooleanArray(cols) { false }
    }

    val queue = LinkedList<IntArray>()

    var time = 0

    grid.forEachIndexed { row, list ->
        list.forEachIndexed { col, value ->
            if (grid[row][col] == 2) {
                queue.add(intArrayOf(row, col))
            }
        }
    }

    fun markRotten(row: Int, col: Int): Boolean {
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] != 1) {
            return false
        }
        grid[row][col] = 2
        return true
    }

    while (queue.isNotEmpty()) {
        val list = mutableListOf<IntArray>()
        while (queue.isNotEmpty()) {
            val (row, col) = queue.remove()
            visited[row][col] = true
            direction.forEach {
                if (markRotten(row + it[0], col + it[1])) {
                    list.add(intArrayOf(row + it[0], col + it[1]))
                }
            }
        }
        list.forEach {
            queue.add(it)
        }
        if (list.size != 0) time++
    }

    grid.forEach {
        if (1 in it) {
            return -1
        }
    }

    return time
}