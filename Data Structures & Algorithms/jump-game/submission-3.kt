class Solution {
    fun canJump(nums: IntArray): Boolean {
        var reachable = nums.lastIndex
        for (i in nums.size - 2 downTo 0) {
            if (i + nums[i] >= reachable) {
                reachable = i
            }
        }

        return reachable == 0
    }
}
