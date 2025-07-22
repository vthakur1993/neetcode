package oneDp

/*
    Leetcode: https://leetcode.com/problems/longest-palindromic-substring/
    Neetcode: https://neetcode.io/problems/longest-palindromic-substring?list=neetcode150
 */

fun longestPalindrome(s: String): String {
    val n = s.length
    val dp = Array(n) { BooleanArray(n) }
    var start = 0
    var maxLength = 1

    // All substrings of length 1 are palindromes
    for (i in 0 until n) {
        dp[i][i] = true
    }

    // Check all substrings of length 2
    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLength = 2
        }
    }

    // Check lengths from 3 to n
    for (len in 3..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (len > maxLength) {
                    start = i
                    maxLength = len
                }
            }
        }
    }
    val temp = dp.sumOf { it ->
        it.count { it }
    }
    println("Total DP :: $temp")
    return s.substring(start, start + maxLength)
}
