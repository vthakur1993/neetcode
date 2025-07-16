package graphs

/**
 *  TimeComplexity: O(4alpha) where alpha is closer to 1
 *  SpaceComplexity: O(N)
 */

class DisjointSet(nodes: Int) {
    private val rank = IntArray(nodes) { 0 }
    private val parent = IntArray(nodes) { it }
    private val size = IntArray(nodes) { 1 }

    fun findParent(node: Int): Int {
        if (node == parent[node]) {
            return node
        }
        parent[node] = findParent(parent[node])
        return parent[node]
    }

    fun unionByRank(x: Int, y: Int) {
        val uX = findParent(x)
        val uY = findParent(y)
        if (uX == uY) return

        if (rank[uX] < rank[uY]) {
            parent[uX] = uY
        } else if (rank[uY] < rank[uX]) {
            parent[uY] = uX
        } else {
            parent[uY] = uX
            rank[uX] += 1
        }
    }

    fun unionBySize(x: Int, y: Int) {
        val uX = findParent(x)
        val uY = findParent(y)
        if (uX == uY) return

        if (size[uX] < size[uY]) {
            parent[uX] = uY
            size[uY] += size[uX]
        } else {
            parent[uY] = uX
            size[uX] += size[uY]
        }
    }

}