import Trie.WordDictionary

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val trie = WordDictionary()
    trie.addWord("car")

    println("Car :: ${trie.search("car")}")
    println("C.r :: ${trie.search("c.r")}")
    println("Ca. :: ${trie.search("ca.")}")
    println(".ar :: ${trie.search(".ar")}")
    println("..r :: ${trie.search("..r")}")
    println(".a. :: ${trie.search(".a.")}")
    println("C.. :: ${trie.search("c..")}")
    println("Cars :: ${trie.search("cars")}")
    println("C... :: ${trie.search("c...")}")
    println("... :: ${trie.search("...")}")
}

