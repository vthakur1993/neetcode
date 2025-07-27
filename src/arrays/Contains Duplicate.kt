package arrays

/*
    Leetcode: https://leetcode.com/problems/contains-duplicate/
    Neetcode: https://neetcode.io/problems/duplicate-integer?list=neetcode150
 */

fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    nums.forEach {
        if (set.contains(it)) return true
        set.add(it)
    }
    return false
}