class Solution {
    fun missingNumber(nums: IntArray): Int {
        var res = nums.size
        nums.forEachIndexed { i, num ->
            res += i - num
        }
        return res
    }
}
