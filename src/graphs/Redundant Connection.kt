package graphs

fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val n = edges.size
    val par = IntArray(n + 1) { it }
    val rank = IntArray(n + 1) { 1 }

    fun find(x: Int): Int {
        if (par[x] != x) {
            par[x] = find(par[x])
        }
        return par[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) {
            return false
        }
        if (rank[rootX] > rank[rootY]) {
            par[rootY] = rootX
            rank[rootX] += rank[rootY]
        } else {
            par[rootX] = rootY
            rank[rootY] += rank[rootX]
        }
        return true
    }

    for ((u, v) in edges) {
        if (!union(u, v)) {
            return intArrayOf(u, v)
        }
    }
    return intArrayOf()
}