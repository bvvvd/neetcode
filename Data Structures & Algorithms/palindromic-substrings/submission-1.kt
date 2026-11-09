class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        fun expand(l: Int, r: Int) {
            var left = l
            var right = r
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
                count++
            }
        }

        for (i in s.indices) {
            expand(i, i)
            expand(i, i + 1)
        }

        return count
    }
}
