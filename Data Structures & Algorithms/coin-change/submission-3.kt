class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in dp.indices) {
            for (coin in coins) {
                if (i >= coin && dp[i - coin] != Int.MAX_VALUE) {
                    dp[i] = minOf(dp[i - coin] + 1, dp[i])
                }
            }
        }
        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }
}
