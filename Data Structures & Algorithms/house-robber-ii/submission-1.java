class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int prev = 0;
        int loot = 0;
        for (int i = start; i < end; i++) {
            int next = Math.max(prev + nums[i], loot);
            prev = loot;
            loot = next;
        }
        return loot;
    }
}
