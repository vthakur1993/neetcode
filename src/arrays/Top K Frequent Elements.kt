package arrays

/*
    Leetcode: https://leetcode.com/problems/top-k-frequent-elements/description/
    Neetcode: https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150
 */

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val count = mutableMapOf<Int, Int>()
    val n = nums.size

    val freq = List(n + 1) { mutableListOf<Int>() }

    nums.forEach {
        count[it] = count.getOrPut(it, { 0 }) + 1
    }

    count.forEach { k, v ->
        freq[v].add(k)
    }
    val list = mutableListOf<Int>()

    for (i in freq.size - 1 downTo 0) {
        freq[i].forEach {
            list.add(it)
            if (list.size == k) {
                return list.toIntArray()
            }
        }
    }

    return list.toIntArray()
}