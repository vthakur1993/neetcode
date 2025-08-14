package graphs.shortestPathAlgorithms

/***
 * Dijkstra’s algorithm finds the shortest path distances from a source to all other nodes in a weighted graph with nonnegative weights
 * 
 * . It maintains a priority queue of frontier nodes and always picks the next closest unvisited vertex.
 * When to use: Use Dijkstra when you have a graph with nonnegative edge weights and you need shortest paths from one source. (If you only need one target, you can stop early.) It’s widely used in road networks, routing protocols, etc.
 * Why needed: To find optimal routes or distances on weighted networks (e.g., map distances, network latency).
 * Identify: Problem asks for shortest paths on a graph with weights ≥ 0, or something like “minimum cost to reach” a destination.
 * Complexity: Using a binary heap, $O((V+E)\log V)$
 * 
 * . (The worst-case is $Θ(E + V\log V)$)
 * Use-case: Single-source shortest path on nonnegative graphs.
 */