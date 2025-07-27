package twoPointers

/*
    Leetcode: https://leetcode.com/problems/valid-palindrome/
    Neetcode: https://neetcode.io/problems/is-palindrome?list=neetcode150
 */

fun isPalindrome(s: String): Boolean {
    var s = s.lowercase().replace(Regex("[^a-z0-9]"), "")

    var i = 0
    var j = s.length - 1

    while(i < j) {
        if (s[i] != s[j]){

            return false
        }
        i++
        j--
    }
    return true
}