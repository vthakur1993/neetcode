data class Node(
    val value: Int,
    var node: Node? = null
)

class CustomQueue {

    var size = 0
    var head: Node? = null
    var tail: Node? = null

    fun enqueue(value: Int){
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            val temp = tail
            temp?.node = node
            tail = node
        }
        size++
    }

    fun dequeue(): Int? {
        if (head == null) return null

        val node = head
        head = head?.node
        if (head == null) tail = null
        size--
        return node?.value
    }

    fun peek(): Int? {
        return head?.value
    }

    fun size() = size

    fun isEmpty() = size() == 0

}