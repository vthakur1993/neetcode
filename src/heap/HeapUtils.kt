package heap

object HeapUtils {
    fun getLeftChildIndex(index: Int): Int = index * 2 + 1
    fun getRightChildIndex(index: Int): Int = index * 2 + 2
    fun getParentIndex(index: Int): Int = (index - 1) / 2

    fun getLeftChild(index: Int, array: IntArray): Int = array[getLeftChildIndex(index)]
    fun getRightChild(index: Int, array: IntArray): Int = array[getRightChildIndex(index)]
    fun getParent(index: Int, array: IntArray): Int = array[getParentIndex(index)]

    fun hasLeftChild(index: Int, size: Int): Boolean = getLeftChildIndex(index) < size
    fun hasRightChild(index: Int, size: Int): Boolean = getRightChildIndex(index) < size
    fun hasParent(index: Int): Boolean = getParentIndex(index) >= 0

    fun swap(left: Int, right: Int, intArray: IntArray) {
        val temp = intArray[left]
        intArray[left] = intArray[right]
        intArray[right] = temp
    }
}