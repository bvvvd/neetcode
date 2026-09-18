class Solution {
    fun findMin(nums: IntArray): Int {
        var left = -1
        var right = nums.size

        while (left + 1 < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] < nums[0]) {
                right = mid
            } else {
                left = mid
            }
        }

        return if (right == nums.size) nums[0] else nums[right]
    }
}
