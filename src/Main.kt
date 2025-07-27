import arrays.decode
import arrays.encode

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val list = mutableListOf<String>("neet", "code", "is","amazing")
    val en = encode(list)
    println(en)
    println(decode(en))

}

