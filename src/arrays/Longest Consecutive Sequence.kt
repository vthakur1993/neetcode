package arrays

/*
    Leetcode: https://leetcode.com/problems/longest-consecutive-sequence/
    Neetcode: https://neetcode.io/problems/longest-consecutive-sequence?list=neetcode150
 */

fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toSet()
    var longest = 0

    for (num in numSet) {
        if ((num - 1) !in numSet) {
            var length = 1
            while ((num + length) in numSet) {
                length++
            }
            longest = maxOf(longest, length)
        }
    }
    return longest
}