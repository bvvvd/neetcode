class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLength = 0
        val seenIndices = mutableMapOf<Char, Int>()
                                                        // start = 2
        for (i in s.indices) {                          // 3
            val c = s[i]                                // a

            seenIndices[c]?.let {                       // 0
                start = maxOf(start, it + 1)                          // 2
            }
            seenIndices[c] = i                          // {a: 0, b: 2}
            maxLength = maxOf(maxLength, i - start + 1) // maxLength = 2
        }

        return maxLength
    }
}
