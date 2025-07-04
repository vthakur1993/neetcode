package backtracking

import Utils.isPalindrome

/*
    LeetCode: https://leetcode.com/problems/palindrome-partitioning/description/
    NeetCode: https://neetcode.io/problems/palindrome-partitioning?list=neetcode150
 */

fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val part = mutableListOf<String>()

    fun dfs(index: Int) {
        if (index >= s.length) {
            result.add(part.toList())
            return
        }
        for (j in index until s.length) {
            if (s.isPalindrome(index,j)) {
                part.add(s.substring(index..j))
                dfs(j+1)
                part.removeAt(part.size - 1)
            }
        }
    }
    dfs(0)
    return result
}