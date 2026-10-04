class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = -1
        var right = nums.size

        while (left + 1 < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] < target) left = mid else right = mid
        }

        return if (nums.size != right && nums[right] == target) right else -1 
    }
}
