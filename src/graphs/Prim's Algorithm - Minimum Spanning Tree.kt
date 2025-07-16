package graphs

import java.util.*

/**

    @param [nodes] Total Number of nodes (0th Index).
    @param [edges] connecting the nodes Ex Array([node, weight], [node, weight]).

    @return Pair<Int, Array<IntArray>> Sum and Min Spanning tree.

    Time Complexity: E log E (While loop and poll in PQ) + E log E (Edges loop and ) ~ E log E
 */

fun minSpanningTreeWithPrim(nodes: Int, edges: Array<Array<IntArray>>): Pair<Int, Array<IntArray>> {
    // IntArray of size 3: [Weight, Node, Parent]
    val priorityQueue = PriorityQueue<IntArray>(compareBy { it[0] })

    val visit = mutableSetOf<Int>()

    val mst = mutableListOf<IntArray>()

    var minSum = 0

    priorityQueue.add(intArrayOf(0, 0, -1))

    while (priorityQueue.isNotEmpty()) {
        val (weight, node, parent) = priorityQueue.poll()

        if (node in visit) {
            continue
        }
        visit.add(node)
        minSum += weight
        mst.add(intArrayOf(node, parent))

        edges[node].forEach { nodes ->
            val (neighNode, neighWt) = nodes
            if (neighNode !in visit) {
                priorityQueue.add(intArrayOf(neighWt, neighNode, node))
            }
        }
    }
    return Pair(minSum, mst.toTypedArray())
}