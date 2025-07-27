package arrays

/*
    Leetcode: https://leetcode.com/problems/encode-and-decode-strings/description/
    Neetcode: https://neetcode.io/problems/string-encode-and-decode?list=neetcode150
 */
fun encode(strs: MutableList<String>): String {
    val str = StringBuilder()
    strs.forEach {
        str.append("*${it.length}*").append(it)
    }
    return str.toString()
}

fun decode(str: String): MutableList<String> {
    val list = mutableListOf<String>()
    val n = str.length
    var i = 0
    while(i < n) {
        val it = str[i]

        if (it == '*') {
            var e = i + 1
            while (e + 1 < n && str[e] != '*') {
                e++
            }
            val length = str.substring(i+1, e).toInt()
            list.add(str.substring(i+3, i + 3 + length))
            i = i + 3 + length
            continue
        }
        i++
    }

    return list
}