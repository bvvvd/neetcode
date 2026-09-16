class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()

        var maxLength = 0
        for (num in nums) {
            if (num - 1 !in set) {
                var sequenceElement = num
                var length = 0

                while (sequenceElement in set) {
                    sequenceElement++
                    length++
                }

                maxLength = maxOf(length, maxLength)
            }
        }

        return maxLength
    }
}
