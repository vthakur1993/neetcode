package arrays

/*
    Leetcode: https://leetcode.com/problems/valid-anagram/
    Neetcode: https://neetcode.io/problems/is-anagram?list=neetcode150
 */

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val nums = IntArray(26) { 0 }

    for (i in 0 until s.length) {
        nums[s[i] - 'a'] += 1
        nums[t[i] - 'a'] -= 1
    }

    nums.forEach {
        if (it != 0) return false
    }
    return true
}