package Trie

/*
Implement Trie Prefix Tree
 */


class Trie {
    private val root = TrieNode()
    fun insertWord(word: String) {
        var node = root
        word.forEach { it ->
            node = node.children.computeIfAbsent(it) { TrieNode() }
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            node = node.children[it] ?: return false
        }
        return node.isEndOfWord
    }

    fun searchRecursive(word: String): Boolean {
        return searchRecursive(root, 0, word)
    }

    private fun searchRecursive(node: TrieNode?, index: Int, word: String): Boolean {
        if (node == null) return false

        if (index == word.length) return node.isEndOfWord

        val ch = word[index]
        return searchRecursive(node.children[ch], index + 1, word)
    }


    fun startsWith(word: String): Boolean {
        var node = root
        word.forEach {
            node = node.children[it] ?: return false
        }
        return true
    }

    fun delete(word: String) {
        val node = root
        deleteHelper(node, word, 0)
    }

    private fun deleteHelper(node: TrieNode?, word: String, index: Int): Boolean {
        if (node == null) return false
        if (index == word.length) {
            if(!node.isEndOfWord) return false
            node.isEndOfWord = false
            return node.children.isEmpty()
        }
        val shouldDeleteChild = deleteHelper(node.children[word[index]], word, index + 1)
        if (shouldDeleteChild) {
            node.children.remove(word[index])
            return node.children.isEmpty() && !node.isEndOfWord
        }
        return false
    }
}