package linkedLists

/*
    Leetcode: https://leetcode.com/problems/reorder-list/
    Neetcode: https://neetcode.io/problems/reorder-linked-list?list=neetcode150
 */

fun reorderList(head: ListNode?): Unit {
    if (head == null || head.next == null) return

    var slow = head
    var fast = head?.next

    while (fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
    }

    var temp = slow?.next
    slow?.next = null
    var curr = temp
    var prev: ListNode? = null

    while (temp != null) {
        var next = temp?.next
        temp?.next = prev
        prev = temp
        temp = next
    }

    var first = head
    var second = prev

    while (second != null && first != null) {
        val firstNext = first?.next
        val secondNext = second?.next

        first?.next = second
        second?.next = firstNext

        first = firstNext
        second = secondNext
    }
}