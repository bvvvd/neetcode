class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val LIS = IntArray(nums.size) { 1 }

        for (i in nums.size - 1 downTo 0) {
            for (j in (i + 1) until nums.size) {
                if (nums[i] < nums[j]) {
                    LIS[i] = maxOf(LIS[i], 1 + LIS[j])
                }
            }
        }

        return LIS.maxOrNull() ?: 1
    }
}