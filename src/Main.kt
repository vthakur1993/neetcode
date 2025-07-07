import java.util.PriorityQueue

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val minHeap = PriorityQueue<Int>()
    var list = listOf(4,5,8,2,3,5,10,9,4)
    list.forEach {
        minHeap.offer(it)
    }
    println(minHeap)
    repeat(list.size) {
        println(minHeap.poll())
    }
}

