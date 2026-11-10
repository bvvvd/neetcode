class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var maxVolume = 0

        while (left < right) {
            maxVolume = maxOf(maxVolume, (right - left) * (minOf(heights[left], heights[right])))

            if (heights[left] < heights[right]) left++ else right--
        }

        return maxVolume
    }
}
