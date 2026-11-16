class Solution {
    fun numberOfSubstrings(s: String): Int {
        var a = 0
        var b = 0
        var c = 0
        var left = 0
        var count = 0
        for (right in s.indices) {
            when (s[right]) {
                'a' -> a++
                'b' -> b++
                'c' -> c++
                else -> throw RuntimeException()
            }
            while (a != 0 && b != 0 && c != 0) {
                count += s.length - right
                when (s[left]) {
                    'a' -> a--
                    'b' -> b--
                    'c' -> c--
                    else -> throw RuntimeException()
                }
                left++
            }
        }
        return count
    }
}
