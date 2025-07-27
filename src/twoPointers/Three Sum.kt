package twoPointers

/*
    Leetcode: https://leetcode.com/problems/3sum/
    Neetcode: https://neetcode.io/problems/three-integer-sum?list=neetcode150
 */

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val n = nums.size

    for (i in 0 until n) {
        val a = nums[i]
        if (a > 0) break

        if (i > 0 && a == nums[i - 1]) continue

        var l = i + 1
        var r = n - 1
        // [-4, -1,-1, 0, 1, 2]
        while (l < r) {
            val threeSum = nums[i] + nums[l] + nums[r]
            if (threeSum > 0) {
                r--
            } else if (threeSum < 0) {
                l++
            } else {
                result.add(listOf(nums[i],nums[l],nums[r]))
                l++
                r--
                while (l < r && nums[l] == nums[l-1]) {
                    l++
                }
            }
        }
    }
    return result
}