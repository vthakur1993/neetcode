package twoPointers

import kotlin.math.max

/*
    Leetcode: https://leetcode.com/problems/3sum/
    Neetcode: https://neetcode.io/problems/three-integer-sum?list=neetcode150
 */

fun maxArea(height: IntArray): Int {
    var l = 0
    val n = height.size

    var r = n - 1
    var maxArea = 0
    while (l < r) {
        val left = height[l]
        val right = height[r]
        var area = 0
        if (left < right) {
            area = (left * (r - l))
            l++
        } else {
            area = (right * (r - l))
            r--
        }
        maxArea = max(maxArea, area)
    }

    return maxArea
}