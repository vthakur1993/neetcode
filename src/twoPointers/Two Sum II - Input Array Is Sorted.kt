package twoPointers

/*
    Leetcode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    Neetcode: https://neetcode.io/problems/two-integer-sum-ii?list=neetcode150
 */
fun twoSum(numbers: IntArray, target: Int): IntArray {
    var l = 0
    var r = numbers.size - 1

    while (l < r) {
        val curSum = numbers[l] + numbers[r]
        when {
            curSum > target -> r--
            curSum < target -> l++
            else -> return intArrayOf(l + 1, r + 1)
        }
    }
    return intArrayOf()
}