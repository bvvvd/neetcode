class Solution {
    fun maxProduct(nums: IntArray): Int {
        val n = nums.size
        var max = nums[0]
        var prefix = 0
        var suffix = 0

        for (i in 0 until n) {
            if (prefix == 0) prefix = 1
            if (suffix == 0) suffix = 1

            prefix *= nums[i]
            suffix *= nums[n - 1 - i]
            max = maxOf(max, prefix, suffix)
        }
        return max
    }
}
