package oneDp

import kotlin.math.max

/*
    Leetcode: https://leetcode.com/problems/house-robber/submissions/1705573032/
    Neetcode: https://neetcode.io/problems/house-robber?list=neetcode150
 */

fun rob(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return nums[0]
    val dp = IntArray(n) { -1 }

    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])

    for (i in 2 until n) {
        dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    }
    return dp[n-1]
}