class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var currentSum = nums[0]
        var maxSum = nums[0]
        for (i in 1 until nums.size) {
            currentSum += nums[i]
            maxSum = maxOf(maxSum, currentSum)
            currentSum = maxOf(currentSum, nums[i])
        }
        
        return maxOf(maxSum, currentSum)
    }
}
