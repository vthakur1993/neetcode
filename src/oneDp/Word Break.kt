package oneDp

/*
    Leetcode: https://leetcode.com/problems/word-break/description/
    Neetcode: https://neetcode.io/problems/word-break?list=neetcode150
 */

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val n = s.length
    val dp = BooleanArray(n + 1) { false }
    dp[n] = true

    for (i in n-1 downTo 0) {
        for (word in wordDict) {
            val l = word.length
            if (i + l <= n && s.substring(i, i+l) == word) {
                dp[i] = dp[i + l]
            }
            if (dp[i]) break
        }
    }

    return dp[0]
}