package Trie


class WordDictionary() {
    val root = TrieNode()

    fun addWord(word: String) {
        var node = root
        word.forEach {
            val temp = node.children.computeIfAbsent(it) { TrieNode() }
            node = temp
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {

        return search(root, 0, word)
    }

    private fun search(node: TrieNode?, index: Int, word: String ): Boolean {
        node?.let { node ->
            if (index == word.length) return node.isEndOfWord

            val ch = word[index]
            if (node.children[ch] != null) return search(node.children[ch], index + 1, word)
            else if (ch == '.') {
                node.children.values.forEach {
                    if (search(it, index+1, word)) return true
                }
            }
        }

        return false
    }

}