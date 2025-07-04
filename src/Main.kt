import Trie.WordDictionary
import backtracking.Subsets
import backtracking.combinationSum

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var temp = "vipul"
    var char = 'a'
    repeat(2) {
        println(it)
    }
    val n = 2
    val matrix = MutableList(n) { // Creates the outer list of size n
        MutableList(n) { '.' }     // For each row, creates an inner list of size n, initialized with '.'
    }
    val list = mutableListOf<String>()
    matrix.forEach {
        list.add(it.joinToString(separator = ""))
    }
    println(list)
}

