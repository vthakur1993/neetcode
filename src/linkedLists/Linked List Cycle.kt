package linkedLists

/*
    Leetcode: https://leetcode.com/problems/linked-list-cycle/description/
    Neetcode: https://neetcode.io/problems/linked-list-cycle-detection?list=neetcode150
 */

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next

    while (fast != null) {
        slow = slow?.next
        fast = fast?.next?.next

        if (fast == slow) return true
    }
    return false
}