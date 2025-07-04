package backtracking

/*
    LeetCode: https://leetcode.com/problems/permutations/
    NeetCode: https://neetcode.io/problems/permutations?list=neetcode150
 */

// My Solution
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val set = mutableSetOf<Int>()
    val n = nums.size

    fun temp(index: Int) {
        val currentNum = nums[index]
        set.add(index)
        if (set.size == n) {
            val list = set.map { nums[it] }
            result.add(list)
            set.remove(index)
            return
        }
        nums.forEachIndexed { i, n ->
            if (!set.contains(i)) temp(i)
        }
        set.remove(index)
    }
    nums.forEachIndexed { i, n ->
        temp(i)
    }

    return result
}


/***
 * Neetcode solution
 *
 *
 * class Solution {
 *     fun permute(nums: IntArray): List<List<Int>> {
 *         if (nums.isEmpty()) return listOf(listOf())
 *
 *         val perms = permute(nums.sliceArray(1 until nums.size))
 *         val res = mutableListOf<List<Int>>()
 *         for (p in perms) {
 *             for (i in 0..p.size) {
 *                 val pCopy = p.toMutableList()
 *                 pCopy.add(i, nums[0])
 *                 res.add(pCopy)
 *             }
 *         }
 *         return res
 *     }
 * }
 *
 *
 *
 */
