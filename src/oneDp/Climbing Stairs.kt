package oneDp

/*
    Leetcode: https://leetcode.com/problems/climbing-stairs/
    Neetcode: https://neetcode.io/problems/climbing-stairs?list=neetcode150
 */

fun climbStairs(n: Int): Int {
    var zero = 1
    var first = 1

    for (i in 2..n) {
        val temp = first + zero
        zero = first
        first = temp

    }

    return first
}