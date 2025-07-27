package arrays

/*
    Leetcode: https://leetcode.com/problems/group-anagrams/
    Neetcode: https://neetcode.io/problems/anagram-groups?list=neetcode150
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()

    strs.forEach {
        val key = it.toCharArray().sorted().joinToString("")
        if (map.contains(key)) {
            map[key]!!.add(it)
        } else {
            map[key] = mutableListOf<String>(it)
        }
    }
    return map.values.toList()
}