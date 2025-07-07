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

/*
    Leetcode: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
    Neetcode: https://neetcode.io/problems/kth-largest-integer-in-a-stream?list=neetcode150
 */

class KthLargest(val k: Int, nums: IntArray) {
    var size = 0
    var newNums = IntArray(k)
    var capacity = nums.size

    init {
        nums.forEach { add(it) }
    }

    private fun ensureCapacity() {
        if (size == capacity) {
            capacity = capacity * 2
            val temp = newNums.copyOf(capacity)
            newNums = temp
        }
    }

    fun heapifyDown() {
        var index = 0
        while(hasLeftChild(index, size)) {
            var smallChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index, size) && newNums[smallChildIndex] > newNums[getRightChildIndex(index)]) {
                smallChildIndex = getRightChildIndex(index)
            }
            if (newNums[index] < newNums[smallChildIndex]) {
                break
            } else{
                swap(index, smallChildIndex, newNums)
            }

            index = smallChildIndex
        }
    }

    fun heapifyUp() {
        var index = size - 1
        while (hasParent(index) && getParent(index, newNums) > newNums[index]) {
            val parentIndex = getParentIndex(index)
            swap(index, parentIndex, newNums)
            index = parentIndex
        }
    }

    fun add(`val`: Int): Int {
        if (size >= k) {
            if (newNums[0] < `val`) {
                newNums[0] = `val`
                heapifyDown()
            }
        } else {
            newNums[size] = `val`
            size++
            heapifyUp()
        }
        return newNums[0]
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */