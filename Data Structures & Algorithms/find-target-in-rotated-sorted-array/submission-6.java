class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int pivot = findPivot(nums) % nums.length;

        if (target == nums[pivot]) {
            return pivot;
        }

        if (pivot == 0) {
            return find(nums, target, 0, nums.length - 1);
        }

        if (nums[0] <= target && nums[pivot - 1] >= target) {
            return find(nums, target, 0, pivot - 1);
        }

        return find(nums, target, pivot, nums.length - 1);
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int find(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
