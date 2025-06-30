package Trie

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        words.forEach {
            trie.insertWord(it)
        }

        val result = mutableSetOf<String>()
        searchWord(trie, result, board)
        return result.toList()
    }

    fun searchWord(trie: Trie, result: MutableSet<String>, board: Array<CharArray>) {
        val visited = Array(board.size) { BooleanArray(board[0]!!.size) }
        board.forEachIndexed { rowIndex, col ->
            col.forEachIndexed { colIndex, ch ->
                if (trie.startsWith(ch.toString())) {
                    search(visited, rowIndex, colIndex, board, trie, result, "")
                }
            }
        }
    }
    fun search(visited: Array<BooleanArray>, rowIndex: Int, colIndex: Int, board: Array<CharArray>, trie: Trie, result: MutableSet<String>, word: String) {
        if (rowIndex < 0 || rowIndex >= board.size || colIndex < 0 || colIndex >= board[0]!!.size) return
        val currentWord = word + board[rowIndex][colIndex].toString()
        if (visited[rowIndex][colIndex]) {
            return
        }
        if (!trie.startsWith(currentWord)) {
            return
        }
        if (trie.search(currentWord) && !result.contains(currentWord)) {
            result.add(currentWord)
            //return
        }

        visited[rowIndex][colIndex] = true
        search(visited, rowIndex + 1, colIndex, board, trie, result, currentWord)
        search(visited, rowIndex - 1, colIndex, board, trie, result, currentWord)
        search(visited, rowIndex, colIndex + 1, board, trie, result, currentWord)
        search(visited, rowIndex, colIndex - 1, board, trie, result, currentWord)
        visited[rowIndex][colIndex] = false
    }
}