class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        fun rob(start: Int, end: Int): Int {
            var twoPre = 0
            var onePre = 0
            for (i in start..end) {
                val current = maxOf(onePre, twoPre + nums[i])
                twoPre = onePre
                onePre = current
            }
            return onePre
        }

        return maxOf(rob(0, nums.size - 2), rob(1, nums.size - 1))
    }
}
