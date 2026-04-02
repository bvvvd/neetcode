class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        flip(nums, 0, nums.length - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, nums.length - 1);
    }

    private void flip(int[] nums, int left, int right) {
        while (left < right) {
            int swap = nums[left];
            nums[left] = nums[right];
            nums[right] = swap;
            left++;
            right--;
        }
    }
}