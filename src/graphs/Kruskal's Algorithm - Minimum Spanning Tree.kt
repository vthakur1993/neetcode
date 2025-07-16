package graphs

import java.util.*

fun minSpanningTreeWithKruskal(nodes: Int, edges: Array<Array<IntArray>>): Pair<Int, Array<IntArray>> {

    val priorityQueue = PriorityQueue<IntArray>(compareBy { it[0] })

    edges.forEachIndexed { index, nodes ->
        nodes.forEach {
            val node = index
            val target = it[0]
            val wt = it[1]

            priorityQueue.add(intArrayOf(wt, node, target))
        }
    }
    val disjointSet = DisjointSet(nodes)
    var sum = 0
    val mst = mutableListOf<IntArray>()

    while (priorityQueue.isNotEmpty()) {
        val (wt, x, y) = priorityQueue.poll()

        if (disjointSet.findParent(x) != disjointSet.findParent(y)) {
            sum += wt
            mst.add(intArrayOf(x, y))
            disjointSet.unionByRank(x, y)
        }
    }

    return Pair(sum, mst.toTypedArray())
}