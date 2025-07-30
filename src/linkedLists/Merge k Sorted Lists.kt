package linkedLists

/*
    Leetcode: https://leetcode.com/problems/merge-k-sorted-lists/description/
    Neetcode: https://neetcode.io/problems/merge-k-sorted-linked-lists?list=neetcode150
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val n = lists.size
    if (lists.size == 0) return null

    var currentLists = lists.toList()
    while (currentLists.size > 1) {
        val mergedList = mutableListOf<ListNode?>()
        for (i in currentLists.indices step 2) {
            val l1 = currentLists[i]
            val l2 = if ( i + 1 >= currentLists.size) null else currentLists[i+1]
            mergedList.add(merge(l1,l2))
        }
        currentLists = mergedList
    }
    return currentLists.first()
}

private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    var l1 = l1
    var l2 = l2

    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            curr.next = l1
            l1 = l1.next
        } else {
            curr.next = l2
            l2 = l2.next
        }
        curr = curr.next!!
    }

    curr.next = l1 ?: l2

    return dummy.next
}