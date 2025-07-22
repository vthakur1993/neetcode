package oneDp

/*
    Leetcode: https://leetcode.com/problems/decode-ways/description/
    Neetcode: https://neetcode.io/problems/decode-ways?list=neetcode150
 */

fun numDecodings(s: String): Int {
    val n = s.length
    if (n == 1) return 1

    val dp = mutableMapOf<Int, Int>(s.length to 1)

    for (i in n-1 downTo 0) {
        if (s[i] == '0') dp[i] = 0
        else {
            dp[i] = dp[i+1] ?: 0
            if (i + 1 < n &&  (s[i] == '1' || (s[i] == '2' && s[i+1] <= '6'))) {
                dp[i] = dp[i]!! + (dp[i+2] ?: 0)
            }
        }
    }
    return dp[0]!!
}