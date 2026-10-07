class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val allCombinations = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()
        nums.sort()
        fun backtrack(index: Int, remain: Int) {
            if (remain == 0) {
                allCombinations.add(combination.toList())
            } else {
                for (i in nums.size - 1 downTo index) {
                    val num = nums[i]

                    if (remain - num >= 0) {
                        combination.add(num)
                        backtrack(i, remain - num)
                        combination.removeLast()
                    } 
                }
            }
        }

        backtrack(0, target)
        return allCombinations
    }
}
