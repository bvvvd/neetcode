class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val leftProducts = IntArray(n)
        leftProducts[0] = 1
        val rightProducts = IntArray(n)
        rightProducts[n - 1] = 1

        for (i in 1 until n) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1]
            rightProducts[n - i - 1] = rightProducts[n - i] * nums[n - i]
        }

        val productsExceptSelf = IntArray(n)
        for (i in nums.indices) {
            productsExceptSelf[i] = leftProducts[i] * rightProducts[i]
        }

        return productsExceptSelf
    }
}
