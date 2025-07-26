package oneDp

/*
    Leetcode: https://leetcode.com/problems/longest-increasing-subsequence/
    Neetcode: https://neetcode.io/problems/longest-increasing-subsequence?list=neetcode150
*/

fun lengthOfLIS(nums: IntArray): Int {
    val dp = mutableListOf<Int>()
    dp.add(nums[0])

    val n = nums.size
    var max = 1
    for (i in 1..n-1) {
        if (dp[dp.size - 1] < nums[i]) {
            dp.add(nums[i])
            max++
            continue
        }
        val idx = dp.binarySearch(nums[i]).let {
            if (it < 0) -it - 1 else it
        }
        dp[idx] = nums[i]
    }

    return max
}