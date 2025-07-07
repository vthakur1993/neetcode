import heap.kClosest
import heap.lastStoneWeight
import java.util.PriorityQueue

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val points = arrayOf(
        intArrayOf(1,3),
        intArrayOf(5,-1),
        intArrayOf(-2,2),
    )
    kClosest(points, 1).forEach {
        println(it.joinToString(separator = ","))
    }

}

