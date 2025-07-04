package Utils

fun String.isPalindrome(): Boolean {
    return isPali(this, 0, this.length - 1)
}

fun String.isPalindrome(left: Int, right: Int): Boolean {
    return isPali(this, left, right)
}

private fun isPali(s: String, l: Int, r: Int): Boolean {
    var left = l
    var right = r
    while (left < right) {
        if (s[left] != s[right]) {
            return false
        }
        left++
        right--
    }
    return true
}