package linkedLists

/*
    Leetcode: https://leetcode.com/problems/copy-list-with-random-pointer/description/
    Neetcode: https://neetcode.io/problems/copy-linked-list-with-random-pointer?list=neetcode150
 */

fun copyRandomList(node: Node?): Node? {
    val map = mutableMapOf<Node, Node>()
    if (node == null) return null
    var curr: Node? = node
    while (curr != null) {
        val newNode = Node(curr.`val`)
        map[curr] = newNode
        curr = curr.next
    }

    curr = node
    while (curr != null) {
        if (map[curr.next] != null) {
            map[curr]!!.next = map[curr.next]!!
        }
        if (map[curr.random] != null) {
            map[curr]!!.random = map[curr.random]!!
        }
        curr = curr.next
    }

    return map[node]!!
}