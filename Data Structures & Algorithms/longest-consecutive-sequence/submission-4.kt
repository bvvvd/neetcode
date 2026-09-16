class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        val starts = mutableListOf<Int>()
        var maxLength = 0
        for (num in nums) {
            if (!set.contains(num - 1)) {
                var sequenceElement = num
                var length = 0

                while (set.contains(sequenceElement)) {
                    set.remove(sequenceElement)
                    sequenceElement++
                    length++
                }

                maxLength = max(length, maxLength)
            }
        }

        return maxLength
    }
}
