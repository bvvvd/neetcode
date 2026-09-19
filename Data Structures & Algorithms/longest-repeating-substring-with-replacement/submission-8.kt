class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val window = IntArray(26)
        var left = 0
        var maxLength = 0
        var maxFrequency = 0

        for (right in s.indices) {
            window[s[right] - 'A']++
            maxFrequency = maxOf(maxFrequency, window[s[right] - 'A'])
            while (right - left + 1 - maxFrequency > k) {
                window[s[left] - 'A']--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
