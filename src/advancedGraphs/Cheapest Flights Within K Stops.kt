package advancedGraphs

import java.util.*

/*
    Leetcode: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
    Neetcode: https://neetcode.io/problems/cheapest-flight-path?list=neetcode150
 */

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val map = mutableMapOf<Int, MutableList<IntArray>>()
    val visited = mutableSetOf<Int>()

    flights.forEach {
        map.getOrPut(it[0], { mutableListOf() }).add(it)
    }

    // W, Dest, K
    var pq = PriorityQueue<IntArray>(compareBy { it[0] })
    pq.add(intArrayOf(0, src, 0))
    var minPriceFromDestination = IntArray(n) { Int.MAX_VALUE }

    while (pq.isNotEmpty()) {

        val (sw, to, stop) = pq.poll()

        if (to == dst) {
            return sw
        }
        if (stop > k || stop > minPriceFromDestination[to]) continue
        minPriceFromDestination[to] = stop

        map[to]?.forEach { (f, t, w) ->
            pq.add(intArrayOf(sw + w , t, stop + 1))
        }
    }

    return if (minPriceFromDestination[dst] == Int.MAX_VALUE) -1 else minPriceFromDestination[dst]
}