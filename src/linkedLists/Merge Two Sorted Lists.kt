package linkedLists

/*
    Leetcode: https://leetcode.com/problems/merge-two-sorted-lists/description/
    Neetcode: https://neetcode.io/problems/merge-two-sorted-linked-lists?list=neetcode150
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var node: ListNode? = dummy

    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            node?.next = l1
            l1 = l1.next
        } else {
            node?.next = l2
            l2 = l2.next
        }
        node = node?.next
    }

    node?.next = l1 ?: l2

    return dummy.next
}