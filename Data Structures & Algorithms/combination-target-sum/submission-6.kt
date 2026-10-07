class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val allCombinations = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()
        nums.sort()
        fun backtrack(start: Int, remain: Int) {
            if (remain == 0) {
                allCombinations.add(combination.toList())
            } else {
                for (i in start until nums.size) {
                    val num = nums[i]

                    if (num > remain) break
                    combination.add(num)
                    backtrack(i, remain - num)
                    combination.removeLast() 
                }
            }
        }

        backtrack(0, target)
        return allCombinations
    }
}
