package graphs

/*
    LeetCode: https://leetcode.com/problems/course-schedule/description/
    NeetCode: https://neetcode.io/problems/course-schedule?list=neetcode150
 */

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val visited = mutableSetOf<Int>()
    val adj = mutableMapOf<Int, MutableList<Int>>()
    val n = numCourses

    for (i in 0 until n) {
        adj[i] = mutableListOf()
    }

    prerequisites.forEachIndexed { index, list ->
        val row = list[0]
        val col = list[1]

        adj[row]!!.add(col)
    }

    fun isCycle(node: Int): Boolean {
        if (visited.contains(node)) return true
        if (adj[node]!!.isEmpty()) return false

        visited.add(node)

        adj[node]!!.forEach {
            if (isCycle(it)) return true
        }
        visited.remove(node)
        adj[node]!!.clear()
        return false
    }
    adj.keys.forEach { key ->
        if (isCycle(key)) {
            return false
        }
    }


    return true
}