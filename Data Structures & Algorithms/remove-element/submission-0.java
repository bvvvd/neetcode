class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int leftmostKIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                int swap = nums[i];
                nums[i] = nums[leftmostKIndex];
                nums[leftmostKIndex] = swap;

                leftmostKIndex--;
            }
        }

        return leftmostKIndex + 1;
    }
}