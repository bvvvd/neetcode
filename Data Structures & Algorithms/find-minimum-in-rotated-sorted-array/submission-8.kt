class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        if (nums[0] <= nums[nums.size - 1]) {
            return nums[0]
        }

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

        return nums[right]
    }
}
