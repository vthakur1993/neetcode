package graphs

/*
    Leetcode: https://leetcode.com/problems/graph-valid-tree/
    Neetcode: https://neetcode.io/problems/valid-tree?list=neetcode150
*/

fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    if (n == 0) return true

    val adj = Array(n) { mutableListOf<Int>() }
    val visit = mutableSetOf<Int>()

    edges.forEach {
        adj[it[0]].add(it[1])
        adj[it[1]].add(it[0])
    }

    fun isCycle(node: Int, prevVal: Int): Boolean {
        if (node in visit) return true

        visit.add(node)
        adj[node].forEach {
            if (it != prevVal) {
                if (isCycle(it, node)) {
                    return true
                }
            }
        }
        return false
    }

    return !isCycle(0, -1) && visit.size == n
}