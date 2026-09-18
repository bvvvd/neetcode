class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        val pivot = findPivot(nums)

        return if (target >= nums[0]) {
            binarySearch(nums, target, -1, pivot)
        } else {
            binarySearch(nums, target, pivot - 1, nums.size)
        }
    }

    private fun findPivot(nums: IntArray): Int {
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

        return right
    }

    private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        var l = left
        var r = right

        while (l + 1 < r) {
            val mid = l + (r - l) / 2

            if (nums[mid] >= target) {
                r = mid
            } else {
                l = mid
            }
        }

        return if (r < nums.size && nums[r] == target) r else -1
    }
}
