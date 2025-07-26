package oneDp

import kotlin.math.max
import kotlin.math.min

/*
    Leetcode: https://leetcode.com/problems/maximum-product-subarray/
    Neetcode: https://neetcode.io/problems/maximum-product-subarray?list=neetcode150
 */

fun maxProduct(nums: IntArray): Int {
    var res = nums[0]
    var curMin = 1
    var curMax = 1

    for (n in nums) {
        val tmp = curMax * n
        curMax = max(max(curMin * n, n), tmp)
        curMin = min(min(curMin * n, n), tmp)
        res = max(res, curMax)
    }

    return res
}