class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int redPointer = 0;
        int bluePointer = nums.length - 1;
        int whitePointer = 0;

        // [2, 1, 0]
        while (whitePointer <= bluePointer) {
            if (nums[whitePointer] == 0) {
                nums[whitePointer] = nums[redPointer];
                nums[redPointer] = 0;
                redPointer++;
                whitePointer++;
            } else if (nums[whitePointer] == 2) {
                nums[whitePointer] = nums[bluePointer]; // [0, 1, 0]
                nums[bluePointer] = 2; // [0, 1, 2]
                bluePointer--; // 1
            } else {
                whitePointer++;
            }
        }
    }
}