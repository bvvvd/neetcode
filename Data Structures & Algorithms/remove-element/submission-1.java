class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int swap = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = swap;
                pointer++;
            }
        }

        return pointer;
    }
}