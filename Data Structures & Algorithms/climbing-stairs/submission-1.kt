class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        for (i in dp.indices) {
            if (i - 2 >= 0) dp[i] += dp[i - 2]
            if (i - 1 >= 0) dp[i] += dp[i - 1]
        }
        return dp[n]
    }
}
