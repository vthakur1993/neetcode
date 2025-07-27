package arrays

/*
    Leetcode: https://leetcode.com/problems/product-of-array-except-self/description/
    Neetcode: https://neetcode.io/problems/products-of-array-discluding-self?list=neetcode150
 */

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { 1 }

    var prefix = 1

    for (i in 0 until n) {
        result[i] = prefix
        prefix *= nums[i]
    }

    var postfix = 1
    for (i in n-1 downTo 0) {
        result[i] = result[i] * postfix
        postfix *= nums[i]
    }

    return result
}