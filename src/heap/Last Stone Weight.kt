package heap

import heap.HeapUtils.hasRightChild
import heap.HeapUtils.hasParent
import heap.HeapUtils.hasLeftChild
import heap.HeapUtils.getRightChild
import heap.HeapUtils.getParent
import heap.HeapUtils.getLeftChild
import heap.HeapUtils.getRightChildIndex
import heap.HeapUtils.getParentIndex
import heap.HeapUtils.getLeftChildIndex
import heap.HeapUtils.swap
import kotlin.math.abs

/*
    Leetcode: https://leetcode.com/problems/last-stone-weight/submissions/1689269180/
    Neetcode: https://neetcode.io/problems/last-stone-weight?list=neetcode150
 */

fun lastStoneWeight(stones: IntArray): Int {
    val maxHeap = MaxHeap(stones.size)

    stones.forEach {
        maxHeap.add(it)
    }

    while (maxHeap.size > 1) {
        val first = maxHeap.poll()
        val second = maxHeap.poll()

        val finalSize = abs(first - second)
        maxHeap.add(finalSize)
    }
    return maxHeap.poll()
}