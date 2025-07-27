package arrays

/*
    Leetcode: https://leetcode.com/problems/two-sum/description/
    Neetcode: https://neetcode.io/problems/two-integer-sum?list=neetcode150
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    var n = 0
    nums.forEach {
        val find = target - it
        if (map.containsKey(find)) {
            return intArrayOf(map[find]!!, n)
        } else {
            map[it] = n
        }
        n++
    }
    return IntArray(2) { 0 }

}


