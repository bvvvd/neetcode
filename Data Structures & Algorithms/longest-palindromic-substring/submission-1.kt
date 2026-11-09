class Solution {
    fun longestPalindrome(s: String): String {
        var left = 0
        var right = 0

        fun expand(l: Int, r: Int): Pair<Int, Int> {
            var left = l
            var right = r
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--;
                right++;
            }

            return left + 1 to right - 1
        }

        for (i in s.indices) {
            val (l, r) = expand(i, i)
            if (r - l > right - left) {
                left = l
                right = r
            }
            val (l2, r2) = expand(i, i + 1)
            if (r2 - l2 > right - left) {
                left = l2
                right = r2
            }
        }

        return s.substring(left, right + 1)
    }
}
