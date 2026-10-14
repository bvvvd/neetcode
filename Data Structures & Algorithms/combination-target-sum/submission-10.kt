class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val dp = Array(target + 1) { mutableListOf<List<Int>>() }
        dp[0].add(mutableListOf<Int>())
        for (num in nums) {
            for (i in dp.indices) {
                if (i >= num) {
                    dp[i - num].forEach {
                        dp[i].add(it + num)
                    }
                }
            }
        }

        return dp[target].toList()
    }
}
