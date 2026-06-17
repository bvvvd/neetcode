class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seenIndexes.containsKey(target - nums[i])) {
                return new int[] {seenIndexes.get(target - nums[i]), i};
            }

            seenIndexes.put(nums[i], i);
        }

        return new int[]{};
    }
}
