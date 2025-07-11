package graphs

/*
    Leetcode: https://leetcode.com/problems/clone-graph/
    Neetcode: https://neetcode.io/problems/clone-graph?list=neetcode150
 */


data class Node(val `val`: Int) {
    val neighbors = ArrayList<Node?>()
}

fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    val oldToNew = mutableMapOf<Node, Node>()

    fun dfs(node: Node): Node {
        if (node in oldToNew) {
            return oldToNew[node]!!
        }

        val copy = Node(node.`val`)
        oldToNew[node] = copy

        node.neighbors.forEach { neig ->
            neig?.let {  copy.neighbors.add(dfs(it))  }
        }

        return copy
    }

    return dfs(node)
}