package graphs

/*
    LeetCode: https://leetcode.com/problems/word-ladder/description/
    NeetCode: https://neetcode.io/problems/word-ladder?list=neetcode150
 */
fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    if (endWord !in wordList || beginWord == endWord) return 0

    var res = 1
    var neig = HashMap<String, MutableList<String>>().withDefault {
        mutableListOf()
    }
    val allWords = wordList.toMutableList().apply {
        if (beginWord !in wordList) {
            add(beginWord)
        }
    }
    allWords.forEachIndexed { i, v ->
        v.forEachIndexed { j, w ->
            val pattern = v.substring(0,j) + "*" + v.substring(j+1)
            neig[pattern] = neig.getOrDefault(pattern, mutableListOf()).apply { add(v) }
        }
    }
    neig.forEach { k, v ->
        println("$k -> ${v.joinToString(separator = ",")}")
    }
    val visit = mutableSetOf<String>(beginWord)
    val queue = ArrayDeque<String>().apply { add(beginWord) }

    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val word = queue.removeFirst()
            if (word == endWord) {
                return res
            }

            word.forEachIndexed { j, c ->
                val pattern = word.substring(0, j) + "*" + word.substring(j+1)
                neig[pattern]?.let { list ->
                    list.forEach {
                        if (visit.add(it)) {
                            queue.add(it)
                        }
                    }
                }
            }
        }
        res++
    }

    return 0
}