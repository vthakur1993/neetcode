package backtracking

/*
    LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    NeetCode: https://neetcode.io/problems/combinations-of-a-phone-number?list=neetcode150
 */

fun letterCombinations(digits: String): List<String> {
    val part = mutableListOf<String>()
    if (digits.isEmpty()) return part
    val n = digits.length
    val map = mapOf<Char, String>(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )
    fun dfs(index: Int, currWord: String) {
        if (index >= n) {
            part.add(currWord)
            return
        }
        val mapWord = map[digits[index]]!!
        mapWord.forEachIndexed { i, c ->
            var newWord = currWord + c
            dfs(index+1, newWord)
        }
    }
    dfs(0, "")
    return part
}