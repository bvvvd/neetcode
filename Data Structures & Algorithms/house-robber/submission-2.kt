class Solution {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1)
        dp[0] = 0
        dp[1] = nums[0]

        for (i in 2 until dp.size) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + nums[i - 1])
        }

        return dp[nums.size]
    }
}
