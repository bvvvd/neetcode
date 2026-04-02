class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] >= nums.length) {
                i++;
                continue;
            }
            int index = nums[i] - 1;
            if (nums[i] != nums[index]) {
                int swap = nums[index];
                nums[index] = nums[i];
                nums[i] = swap;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}