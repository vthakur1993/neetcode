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

class MaxHeap(val initalCapacity: Int) {

    var maxCapacity = initalCapacity
    var size = 0
    var intArray = IntArray(maxCapacity)

    private fun ensureCapacity() {
        if (size == maxCapacity) {
            maxCapacity = maxCapacity * 2
            val temp = intArray.copyOf(maxCapacity)
            intArray = temp
        }
    }

    fun peek(): Int {
        return if (size == 0) {
            throw IllegalStateException("Array is empty")
        } else {
            intArray[0]
        }
    }

    fun poll(): Int {
        if (size == 0) throw IllegalStateException("Array is empty")
        val temp = intArray[0]
        intArray[0] = intArray[size - 1]
        size--
        heapifyDown()
        return temp
    }


    fun add(num: Int) {
        ensureCapacity()
        intArray[size] = num
        size++
        heapifyUp()
    }

    private fun heapifyDown() {
        var index = 0
        while(hasLeftChild(index, size)) {
            var biggerChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index, size) && getRightChild(index, intArray) > intArray[biggerChildIndex]) {
                biggerChildIndex = getRightChildIndex(index)
            }

            if (intArray[index] > intArray[biggerChildIndex]) {
                break
            } else {
                swap(index, biggerChildIndex, intArray)
            }
            index = biggerChildIndex
        }
    }

    private fun heapifyUp() {
        var index = size - 1
        while (hasParent(index) && getParent(index, intArray) < intArray[index]) {
            val parentIndex = getParentIndex(index)
            swap(index, getParentIndex(index), intArray)
            index = parentIndex
        }
    }
}