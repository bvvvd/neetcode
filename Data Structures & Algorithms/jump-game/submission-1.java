class Solution {
    public boolean canJump(int[] nums) {
        int reachable = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }

            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}
