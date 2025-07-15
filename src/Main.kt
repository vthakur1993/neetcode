import graphs.isCycleDFS

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var n = 5
    var adj = arrayOf(
        intArrayOf(1),
        intArrayOf(0, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 4),
        intArrayOf(3)
    )
    println("false -> ${isCycleDFS(n, adj)}")

    n = 3
    adj = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(0, 2),
        intArrayOf(0, 1)
    )
    println("true -> ${isCycleDFS(n, adj)}")

    n = 6
    adj = arrayOf(
        intArrayOf(1),         // 0–1
        intArrayOf(0),
        intArrayOf(3, 4),      // 2–3–4–2 (cycle)
        intArrayOf(2, 4),
        intArrayOf(2, 3),
        intArrayOf()           // node 5 is isolated
    )
    println("true -> ${isCycleDFS(n, adj)}")

    n = 1000
    adj = Array(n) { intArrayOf() }
    for (i in 0 until n - 1) {
        adj[i] = intArrayOf(i + 1)
        adj[i + 1] = intArrayOf(i)  // undirected edge
    }
    println("false -> ${isCycleDFS(n, adj)}")

    n = 6
    adj = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0, 2),
        intArrayOf(0, 1),
        intArrayOf(0, 4, 5),
        intArrayOf(3),
        intArrayOf(3)
    )
    println("true -> ${isCycleDFS(n, adj)}")

    n = 8
    adj = arrayOf(
        intArrayOf(1, 2),        // 0–1–2–0
        intArrayOf(0, 2),
        intArrayOf(0, 1),
        intArrayOf(4, 5),        // 3–4–5–3
        intArrayOf(3, 5),
        intArrayOf(3, 4),
        intArrayOf(),            // 6 isolated
        intArrayOf()             // 7 isolated
    )
    println("true -> ${isCycleDFS(n, adj)}")

    n = 5
    adj = Array(n) { i ->
        (0 until n).filter { it != i }.toIntArray()
    }
    println("true -> ${isCycleDFS(n, adj)}")

    n = 6
    adj = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0)
    )
    println("false -> ${isCycleDFS(n, adj)}")
}

