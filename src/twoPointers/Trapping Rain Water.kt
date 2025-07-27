package twoPointers

/*
    Leetcode: https://leetcode.com/problems/trapping-rain-water/description/
    Neetcode: https://neetcode.io/problems/trapping-rain-water?list=neetcode150
 */

fun trap(height: IntArray): Int {
    val n = height.size

    var l = 0
    var r = n - 1
    var leftMax = height[l]
    var rightMax = height[r]
    var res = 0

    while (l < r) {
        if (leftMax < rightMax) {
            l++
            leftMax = maxOf(leftMax, height[l])
            res += leftMax - height[l]
        } else {
            r--
            rightMax = maxOf(rightMax, height[r])
            res += rightMax - height[r]
        }
    }

    return res
}