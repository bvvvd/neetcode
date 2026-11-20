class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val greaterElements = mutableMapOf<Int, Int>()
        val stack = ArrayDeque<Int>()
        for (i in nums2.lastIndex downTo 0) {
            while (stack.isNotEmpty() && stack.first() <= nums2[i]) {
                stack.removeFirst()
            }
            greaterElements[nums2[i]] = if (stack.isNotEmpty()) stack.first() else -1
            stack.addFirst(nums2[i]) 
        }

        return nums1.map{ greaterElements[it]!! }.toIntArray()
    }
}
