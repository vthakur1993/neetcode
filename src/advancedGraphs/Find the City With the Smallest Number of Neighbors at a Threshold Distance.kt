package advancedGraphs

import kotlin.math.min

/*
    Leetcode: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=problem-list-v2&envId=shortest-path
 */

fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {

    var matrix = Array<IntArray>(n) {
        IntArray(n) { Int.MAX_VALUE }
    }
    repeat(n) {
        matrix[it][it] = 0
    }
    edges.forEach { (i,j,w) ->
        if (w <= distanceThreshold) {
            matrix[i][j] = w
            matrix[j][i] = w
        }
    }

    for (via in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][via] != Int.MAX_VALUE &&  matrix[via][j] != Int.MAX_VALUE) {
                    val dist = matrix[i][via] + matrix[via][j]
                    if (dist <= distanceThreshold && i != j) {
                        matrix[i][j] = min(matrix[i][j], dist)
                    }
                }
            }
        }
    }

    var city = Int.MAX_VALUE
    var cityNumber = -1
    for (i in 0 until n) {
        var tempCity = 0
        for (j in 0 until n) {
            if (matrix[i][j] != Int.MAX_VALUE) {
                tempCity++
            }
        }
        if (tempCity <= city) {
            city = tempCity
            cityNumber = i
        }
    }
    return cityNumber
}