class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val triplets = mutableListOf<List<Int>>()

        for (pivot in 0..nums.size - 3) {
            if (pivot == 0 || nums[pivot] != nums[pivot - 1]) {
                var left = pivot + 1
                var right = nums.size - 1

                while (left < right) {
                    val sum = nums[left] + nums[right] + nums[pivot]
                    if (sum == 0) {
                        triplets.add(listOf(nums[pivot], nums[left], nums[right]))

                        do {
                            left++
                        } while (left < right && nums[left] == nums[left - 1])
                        do {
                            right--
                        } while (left < right && nums[right] == nums[right + 1])
                    } else if (sum < 0) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }

        return triplets
    }
}
