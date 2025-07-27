package linkedLists

/*
    Leetcode: https://leetcode.com/problems/reverse-linked-list/
    Neetcode: https://neetcode.io/problems/reverse-a-linked-list?list=neetcode150
 */

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return head

    var curr = head
    var prev: ListNode? = null

    while(curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}