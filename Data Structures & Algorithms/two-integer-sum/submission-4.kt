class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seenIndices = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            seenIndices[target - num]?.let { j -> return intArrayOf(j, i)}
            seenIndices[num] = i
        }

        return intArrayOf(-1, -1)
    }
}
