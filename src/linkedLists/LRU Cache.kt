package linkedLists

/*
    Leetcode: https://leetcode.com/problems/lru-cache/description/
    Neetcode: https://neetcode.io/problems/lru-cache?list=neetcode150
 */

class LRUCache(val capacity: Int) {
    private val map = mutableMapOf<Int, Node>()
    private var head: Node? = null
    private var tail: Node? = null

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return

        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            moveToHead(node)
            return
        }

        val newNode = Node(key, value)
        map[key] = newNode
        addToHead(newNode)

        if (map.size > capacity) {
            removeTail()
        }
    }

    private fun moveToHead(node: Node) {
        if (node == head) return

        removeNode(node)
        addToHead(node)
    }

    private fun addToHead(node: Node) {
        node.prev = null
        node.next = head

        head?.prev = node
        head = node

        if (tail == null) {
            tail = head
        }
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev

        if (node == tail) {
            tail = node.prev
        }
    }

    private fun removeTail() {
        tail?.let {
            map.remove(it.key)
            removeNode(it)
        }
    }

    private data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */