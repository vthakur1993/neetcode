package graphs

fun isCycleDFS(n: Int, adj: Array<IntArray>): Boolean {

    val visit = BooleanArray(n)

    fun isCycle(node: Int, par: Int): Boolean {
        if (visit[node]) {
            return true
        }
        visit[node] = true
        for (it in adj[node]) {
            if (it == par) continue
            if (isCycle(it, node)){
                return true
            }
        }
        visit[node] = false
        return false
    }

    repeat(n) {
        if (!visit[it]) {
            if (isCycle(it, -1)) {
                return true
            }
        }
    }

    return false
}