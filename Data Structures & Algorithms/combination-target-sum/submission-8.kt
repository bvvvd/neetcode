class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val dp = Array(target + 1) { mutableListOf<List<Int>>() }
        dp[0].add(emptyList())

        for (num in nums) {
            for (i in num..target) {
                for (combination in dp[i - num]) {
                    dp[i].add(combination + num)
                }
            }
        }

        return dp[target]
    }
}
