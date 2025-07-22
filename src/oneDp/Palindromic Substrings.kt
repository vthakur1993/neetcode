package oneDp
/*
    Leetcode: https://leetcode.com/problems/palindromic-substrings/description/
    Neetcode: https://neetcode.io/problems/palindromic-substrings?list=neetcode150
 */
fun countSubstrings(s: String): Int {
    val n = s.length
    val dp = Array<BooleanArray>(n) { BooleanArray(n) { false }}

    for (i in 0 until n) {
        dp[i][i] = true
    }

    for (i in 0 until n - 1) {
        if (s[i] == s[i+1]) dp[i][i+1] = true
    }

    for (k in 3..n) {
        for (i in 0..n - k) {
            val j = i + k - 1
            if (s[i] == s[j] && dp[i+1][j-1]) {
                dp[i][j] = true
            }
        }
    }
    return dp.sumOf { it ->
        it.count { it }
    }
}