package heap

import java.util.PriorityQueue

class MedianFinder() {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    fun addNum(num: Int) {
        if (minHeap.isNotEmpty() && minHeap.peek() < num) {
            minHeap.add(num)
        } else {
            maxHeap.add(num)
        }

        if (minHeap.size > maxHeap.size + 1) {
            maxHeap.add(minHeap.poll())
        }
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else if (maxHeap.size < minHeap.size) {
            minHeap.peek().toDouble()
        } else {
            (maxHeap.peek().toDouble() + minHeap.peek().toDouble()) / 2
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */