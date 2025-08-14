package graphs.shortestPathAlgorithms

/**
 * Bellman–Ford computes shortest paths from a single source allowing negative edge weights, and it can detect negative cycles
 * en.wikipedia.org
 * en.wikipedia.org
 * . It relaxes all edges $V-1$ times.
 * When to use: Use Bellman–Ford if the graph may have negative-weight edges (but no negative cycles) or if you need to detect a negative cycle.
 * Why needed: Some problems have costs or gains (negative weights), so Dijkstra cannot handle those safely. Bellman–Ford is more versatile at the cost of speed.
 * Identify: Graph contains negative edge weights or explicitly asks to handle/report negative cycles.
 * Complexity: $O(VE)$. (Worst-case Θ($V\cdot E$)) Space $O(V)$.
 */

fun bellmanFord(n: Int, edges: List<Triple<Int,Int,Int>>, src: Int): IntArray {
    val dist = IntArray(n) { Int.MAX_VALUE }
    dist[src] = 0
    repeat(n-1) {
        for ((u,v,w) in edges) {
            if (dist[u] != Int.MAX_VALUE && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w
            }
        }
    }
    return dist
}