package oneDp

import kotlin.math.max

/*
    Leetcode: https://leetcode.com/problems/house-robber-ii/description/
    Neetcode: https://neetcode.io/problems/house-robber-ii?list=neetcode150
 */

fun robII(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return nums[0]
    return max(robSlice(nums.copyOfRange(0, n-1)), robSlice(nums.copyOfRange(1, n)))
}

fun robSlice(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    if (nums.size == 1) {
        return nums[0]
    }
    val n = nums.size
    val dp = IntArray(n) { -1 }

    dp[0] = nums[0]
    dp[1] = max(nums[1], nums[0])
    for (i in 2 until n) {
        dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    }
    return dp[n-1]
}