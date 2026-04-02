class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int[] colorCounts = new int[3];
        for (int num: nums) {
            colorCounts[num]++;
        }

        for (int i = 0; i < colorCounts[0]; i++) {
            nums[i] = 0;
        }
        for (int i = colorCounts[0]; i < colorCounts[0] + colorCounts[1]; i++) {
            nums[i] = 1;
        }
        for (int i = colorCounts[0] + colorCounts[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}