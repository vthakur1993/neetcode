package backtracking

/*
    Leetcode: https://leetcode.com/problems/subsets-ii/
    Neetcode: https://neetcode.io/problems/subsets-ii?list=neetcode150

    Time Complexity: O(n * 2^n)
    Space Complexity: O(2^n)
 */

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>(emptyList())
    nums.sort()

    val list = mutableListOf<Int>()
    val n = nums.size

    fun subset(index: Int) {
        if (index >= n) return
        val curr = nums[index]

        list.add(curr)
        result.add(list.toList())
        subset(index + 1)

        list.remove(curr)
        var index = index
        while(index + 1 < n && nums[index] == nums[index + 1]) {
            index++
        }
        subset(index + 1)
    }
    subset(0)
    return result
}