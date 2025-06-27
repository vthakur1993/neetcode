package Trie

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
    var isEndOfWord: Boolean = false
)
