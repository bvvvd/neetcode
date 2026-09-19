class Solution {
    fun findMin(nums: IntArray): Int {
        var left = -1
        var right = nums.size - 1

        while (left + 1 < right) {
            var mid = left + (right - left) / 2

            if (nums[mid] < nums[nums.size - 1]) {
                right = mid
            } else {
                left = mid
            }
        }

        return if (right == nums.size) nums[0] else nums[right] 
    }
}
