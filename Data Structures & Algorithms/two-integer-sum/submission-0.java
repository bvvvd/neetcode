class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }

        Map<Integer, Integer> seenNumberToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer matchIndex = seenNumberToIndex.get(target - nums[i]);

            if (matchIndex != null) {
                return new int[] {matchIndex, i};
            }

            seenNumberToIndex.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
