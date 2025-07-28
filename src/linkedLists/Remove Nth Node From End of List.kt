package linkedLists

/*
    Leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    Neetcode: https://neetcode.io/problems/remove-node-from-end-of-linked-list?list=neetcode150
 */

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0).apply { next = head }
    var left: ListNode? = dummy
    var right: ListNode? = head

    var count = n
    while (count > 0) {
        right = right?.next
        count--
    }

    while (right != null) {
        left = left?.next
        right = right.next
    }

    left?.next = left?.next?.next
    return dummy.next
}