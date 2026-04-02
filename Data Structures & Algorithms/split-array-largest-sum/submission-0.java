class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;      // max element
        int right = 0;     // sum of all elements
        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int cap, int k) {
        int parts = 1;
        int sum = 0;

        for (int x : nums) {
            if (sum + x <= cap) {
                sum += x;
            } else {
                parts++;
                sum = x;
                if (parts > k) return false;
            }
        }
        return true;
    }
}
