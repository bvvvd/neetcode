class Solution {
    fun countSubstrings(s: String): Int {
        fun expand(l: Int, r: Int): Int {
            var left = l
            var right = r
            var count = 0
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
                count++
            }
            return count
        }

        return s.indices.sumOf { expand(it, it) + expand(it, it + 1) }
    }
}
