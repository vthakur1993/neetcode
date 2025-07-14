package graphs

/*
    Leetcode: https://leetcode.com/problems/course-schedule-ii/description/
    Neetcode: https://neetcode.io/problems/course-schedule-ii?list=neetcode150
 */

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val visited = mutableSetOf<Int>()
    val cycle = mutableSetOf<Int>()
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
    var list: MutableList<Int> = mutableListOf()

    fun isCycle(node: Int): Boolean {
        if (node in cycle) return true
        if (node in visited) return false

        cycle.add(node)

        adj[node]!!.forEach {
            if (isCycle(it)) return true
        }

        cycle.remove(node)
        visited.add(node)
        list.add(node)
        return false
    }


    adj.keys.forEach { key ->
        if (isCycle(key)) return intArrayOf()
    }

    return list.toIntArray()
}