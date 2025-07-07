package heap

class MinHeap(val initalCapacity: Int) {

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
        while (HeapUtils.hasLeftChild(index, size)) {
            var smallerChildIndex = HeapUtils.getLeftChildIndex(index)
            if (HeapUtils.hasRightChild(index, size) && HeapUtils.getRightChild(index, intArray) < intArray[smallerChildIndex]) {
                smallerChildIndex = HeapUtils.getRightChildIndex(index)
            }

            if (intArray[index] < intArray[smallerChildIndex]) {
                break
            } else {
                HeapUtils.swap(index, smallerChildIndex, intArray)
            }
            index = smallerChildIndex
        }
    }

    private fun heapifyUp() {
        var index = size - 1
        while (HeapUtils.hasParent(index) && HeapUtils.getParent(index, intArray) > intArray[index]) {
            val parentIndex = HeapUtils.getParentIndex(index)
            HeapUtils.swap(index, parentIndex, intArray)
            index = parentIndex
        }
    }
}
