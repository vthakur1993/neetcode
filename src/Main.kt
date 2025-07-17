//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val q = ArrayDeque<Int>()
    q.add(1)
    q.add(2)
    q.add(3)
    q.add(4)
    q.add(5)
    q.add(6)
    q.add(7)

    println(q.joinToString(separator = ","))

    q.removeFirst()
    println(q.joinToString(separator = ","))

    q.removeFirst()
    println(q.joinToString(separator = ","))

    q.removeLast()
    println(q.joinToString(separator = ","))

}

