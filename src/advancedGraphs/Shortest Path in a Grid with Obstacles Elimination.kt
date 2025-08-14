package advancedGraphs

import java.util.*

/*
    Leetcode: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */

fun shortestPath(grid: Array<IntArray>, k: Int): Int {
    val rows = grid.size
    val cols = grid[0].size

    val visited = mutableSetOf<Triple<Int, Int, Int>>()

    val queue = LinkedList<IntArray>()

    queue.add(intArrayOf(0,0,k))

    val direction = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
    )
    var steps = 0

    while (queue.isNotEmpty()) {
        var size = queue.size
        while (size > 0) {
            val (i, j, obs) = queue.poll()
            if (i == rows - 1 && j == cols - 1) {
                return steps
            }
            for (temp in 0 until direction.size) {
                val it = direction[temp]
                val newR = i + it[0]
                val newC = j + it[1]

                if (newC < 0 || newC >= cols || newR < 0 || newR >= rows) continue

                if (grid[newR][newC] == 0 && !visited.contains(Triple(newR, newC, obs))) {
                    visited.add(Triple(newR, newC, obs))
                    queue.offer(intArrayOf(newR,newC, obs))
                } else if (grid[newR][newC] == 1 && obs > 0 && !visited.contains(Triple(newR, newC, obs - 1))) {
                    visited.add(Triple(newR, newC, obs - 1))
                    queue.offer(intArrayOf(newR,newC, obs - 1))
                }
            }
            --size
        }
        steps++
    }
    return -1
}