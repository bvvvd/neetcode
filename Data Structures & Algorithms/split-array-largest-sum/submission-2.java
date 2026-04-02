class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int left = 1;
        int right = sum;
        int minSum = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                minSum = Math.min(minSum, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minSum;
    }

    private boolean canSplit(int[] nums, int k, int capacity) {
        int remainingCapacity = capacity;
        int arraysNeeded = 1;
        for (int num: nums) {
            if (num > capacity) {
                return false;
            }

            if (num > remainingCapacity) {
                remainingCapacity = capacity;
                arraysNeeded++;
            }
            if (arraysNeeded > k) {
                return false;
            }
            remainingCapacity -= num;
        }

        return true;
    }
}