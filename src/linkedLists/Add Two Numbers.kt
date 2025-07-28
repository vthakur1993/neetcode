package linkedLists

/*
    Leetcode: https://leetcode.com/problems/add-two-numbers/description/
    Neetcode: https://neetcode.io/problems/add-two-numbers?list=neetcode150
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var carr = 0
    var dummy =  ListNode(0)
    var l1 = l1
    var l2 = l2
    var curr = dummy
    while(l1 != null || l2 != null) {
        var temp = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carr
        carr = temp / 10
        temp = temp % 10

        val node = ListNode(temp)
        curr.next = node
        curr = curr.next!!
        l1 = l1?.next
        l2 = l2?.next
    }

    if (carr != 0) {
        curr.next = ListNode(carr)
    }

    return dummy.next
}