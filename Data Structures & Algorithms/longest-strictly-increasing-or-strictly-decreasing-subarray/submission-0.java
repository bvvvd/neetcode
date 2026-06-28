class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxDec = 1;
        int currentDec = 1;
        int maxInc = 1;
        int currentInc = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                currentInc++;
                currentDec = 1;
            } else if (nums[i] > nums[i - 1]) {
                currentDec++;
                currentInc = 1;
            } else {
                currentDec = 1;
                currentInc = 1;
            }
            maxDec = Math.max(currentDec, maxDec);
            maxInc = Math.max(currentInc, maxInc);
        }

        return Math.max(maxInc, maxDec);
    }
}