class Solution {
    fun longestPalindrome(s: String): String {
        var low = 0
        var high = 0

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
            if (r - l > high - low) {
                low = l
                high = r
            }
            val (l2, r2) = expand(i, i + 1)
            if (r2 - l2 > high - low) {
                low = l2
                high = r2
            }
        }

        return s.substring(low, high + 1)
    }
}
