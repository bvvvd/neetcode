class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int num: nums) {
            if (num == 1) {
                current++;
            } else {
                max = Math.max(current, max);
                current = 0;
            }
        }

        return Math.max(max, current);
    }
}