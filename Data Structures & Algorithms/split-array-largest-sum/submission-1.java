class Solution {
    public int splitArray(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int left = max;
        int right = prefix[prefix.length - 1];
        int targetSum = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(prefix, mid, k)) {
                targetSum = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return targetSum;
    }

    private boolean canSplit(int[] prefix, int capacity, int k) {
        int subarrays = 0;
        int i = 0;
        while (i < prefix.length - 1) {
            int left = i + 1;
            int right = prefix.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] - prefix[i] <= capacity) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            subarrays++;
            i = right;

            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }
}