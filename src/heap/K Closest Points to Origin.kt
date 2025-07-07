package heap

import kotlin.math.pow
import kotlin.math.sqrt
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
    Leetcode: https://leetcode.com/problems/k-closest-points-to-origin/
    Neetcode: https://neetcode.io/problems/k-closest-points-to-origin?list=neetcode150
 */

data class PointAndDistance(
    val point: IntArray,
    val distance: Double
)

var list = mutableListOf<PointAndDistance>()
var result = mutableListOf<IntArray>()
var size = 0


fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    points.forEach {
        add(it)
    }
    var k = k
    while (k > 0) {
        result.add(poll())
        k--
    }
    return result.toTypedArray()
}

fun add(point: IntArray) {
    val distance = sqrt( point[0].toDouble().pow(2) + point[1].toDouble().pow(2))
    val pointAndDistance = PointAndDistance(point, distance)
    list.add(size, pointAndDistance)
    size++
    heapifyUp()
}

fun poll(): IntArray {
    val pointAndDistance = list.get(0)
    list.set(0, list.get(size - 1))
    heapifyDown()
    size--
    return pointAndDistance.point
}

fun heapifyDown() {
    var index = 0
    while (hasLeftChild(index, size)) {
        var smallChildIndex = getLeftChildIndex(index)
        if (hasRightChild(index, size) && list[smallChildIndex].distance > list[getRightChildIndex(index)].distance) {
            smallChildIndex = getRightChildIndex(index)
        }
        if (list[index].distance > list[smallChildIndex].distance) {
            val temp = list[index]
            list[index] = list[smallChildIndex]
            list[smallChildIndex] = temp
            index = smallChildIndex
        } else {
            break
        }

    }
}

fun heapifyUp() {
    var index = size - 1

    while (hasParent(index) && list[getParentIndex(index)].distance > list[index].distance) {
        val parentIndex = getParentIndex(index)
        val temp = list[parentIndex]
        list[parentIndex] = list[index]
        list[index] = temp
        index = parentIndex
    }
}


