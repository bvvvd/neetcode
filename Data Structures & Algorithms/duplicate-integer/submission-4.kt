class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val uniqueNumbers = mutableSetOf<Int>()
        nums.forEach {
            if (!uniqueNumbers.add(it)) {
                return true
            }
        }

        return false
    }
}
