class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null) {
            return new int[]{};
        }

        return sort(nums);
    }

    private int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int swap = nums[0];
                nums[0] = nums[1];
                nums[1] = swap;
            }

            return nums;
        }

        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[left.length + i];
        }
        int[] leftSorted = sort(left);
        int[] rightSorted = sort(right);

        return merge(leftSorted, rightSorted);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex == left.length) {
                merged[leftIndex + rightIndex] = right[rightIndex];
                rightIndex++;
            } else if (rightIndex == right.length) {
                merged[leftIndex + rightIndex] = left[leftIndex];
                leftIndex++;
            } else if (left[leftIndex] < right[rightIndex]) {
                merged[leftIndex + rightIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[leftIndex + rightIndex] = right[rightIndex];
                rightIndex++;
            }
        }

        return merged;
    }

}