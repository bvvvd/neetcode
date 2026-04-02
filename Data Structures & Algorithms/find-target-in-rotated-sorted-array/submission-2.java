class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        if (nums[0] < nums[nums.length - 1]) {
            return search(nums, target, 0, nums.length - 1);
        }

        int pivot = findPivot(nums);

        if (target == nums[pivot]) {
            return pivot;
        }

        // recheck
        if (target >= nums[0] && target <= nums[pivot - 1]) {
            return search(nums, target, 0, pivot - 1);
        } else {
            return search(nums, target, pivot, nums.length - 1);
        }
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
                return mid + 1;
            } else if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
