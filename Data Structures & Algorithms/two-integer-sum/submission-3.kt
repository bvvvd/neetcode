class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seenIndices = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, it ->
            seenIndices[target - it]?.let { index -> return intArrayOf(index, i)}
            seenIndices[it] = i
        }

        return intArrayOf(-1, -1)
    }
}
