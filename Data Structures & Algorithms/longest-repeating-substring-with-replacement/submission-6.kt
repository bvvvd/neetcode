class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val window = IntArray(26)
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            window[s[right] - 'A']++
            while (exceeds(window, k)) {
                window[s[left] - 'A']--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }

    private fun exceeds(window: IntArray, k: Int): Boolean {
        var max = 0
        var sum = 0
        for (frequency in window) {
            max = maxOf(max, frequency)
            sum += frequency
        }

        return sum - max > k
    }
}
