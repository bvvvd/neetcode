class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num: nums) {
            if (sum < 0) {
                sum = 0;
            }

            sum += num;
            if (maxSum < sum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
