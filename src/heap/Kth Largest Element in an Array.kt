package heap

/*
    Leetcode: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
    Neetcode: https://neetcode.io/problems/kth-largest-element-in-an-array?list=neetcode150
 */

fun findKthLargest(nums: IntArray, k: Int): Int {
    val newNums = MaxHeap(nums.size)
    nums.forEach {
        newNums.add(it)
    }
    var k = k
    var result = 0
    while (k > 0) {
        result = newNums.poll()
        k--
    }

    return result
}