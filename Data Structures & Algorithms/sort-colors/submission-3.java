class Solution {
    public void sortColors(int[] nums) {
        int redIndex = 0;
        int whiteIndex = 0;
        int blueIndex = nums.length - 1;

        // [2,0,1]
        while (whiteIndex <= blueIndex) {
            if (nums[whiteIndex] == 2) {
                int swap = nums[blueIndex];
                nums[blueIndex] = nums[whiteIndex];
                nums[whiteIndex] = swap;
                blueIndex--;
            } else if (nums[whiteIndex] == 0) {
                int swap = nums[redIndex];
                nums[redIndex] = nums[whiteIndex];
                nums[whiteIndex] = swap;
                whiteIndex++;
                redIndex++;
            } else {
                whiteIndex++;
            }
        }
    }
}