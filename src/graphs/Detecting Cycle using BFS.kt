package graphs

import java.util.*

fun isCycleBFS(n: Int, adj: Array<IntArray>): Boolean {
    val visit = BooleanArray(n)

    repeat(n) {
        if (!visit[it]) {
            if (isCyclePresent(it, visit, adj)) {
                return true
            }
        }
    }

    return false
}

private fun isCyclePresent(
    node: Int, visit: BooleanArray, adj: Array<IntArray>
): Boolean {
    val queue = LinkedList<IntArray>()
    queue.add(intArrayOf(node, -1))

    while (queue.isNotEmpty()) {
        val (node, par) = queue.poll()

        if (visit[node]) {
            return true
        }

        visit[node] = true

        for (it in adj[node]) {
            if (it == par) continue
            queue.add(intArrayOf(it, node))
        }
    }
    return false
}