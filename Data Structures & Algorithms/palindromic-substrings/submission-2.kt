class Solution {
    fun countSubstrings(s: String): Int {
        var totalCount = 0
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

        for (i in s.indices) {
            totalCount += expand(i, i) + expand(i, i + 1)
        }

        return totalCount
    }
}
