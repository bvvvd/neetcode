class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val seen = mutableSetOf<Int>()
        return nums.any { !seen.add(it) }
    }
}
