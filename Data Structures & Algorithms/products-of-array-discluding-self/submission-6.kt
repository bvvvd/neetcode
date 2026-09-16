class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val products = IntArray(n)
        products[0] = 1
        
        for (i in 1 until n) {
            products[i] = products[i - 1] * nums[i - 1]
        }

        var rightProduct = 1
        for (i in n - 1 downTo 0) {
            products[i] = products[i] * rightProduct
            rightProduct *= nums[i]
        }

        return products
    }
}
