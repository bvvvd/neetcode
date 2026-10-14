class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val combinations = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()
        nums.sort()
        fun backtrack(index: Int, remain: Int) {
            if (remain == 0) {
                combinations.add(combination.toList())
            } else {
                for (i in index..nums.lastIndex) {
                    if (remain >= nums[i]) {
                        combination.add(nums[i])
                        backtrack(i, remain - nums[i])
                        combination.removeLast()
                    }
                }
            }
        }
        backtrack(0, target)
        return combinations
    }
}
