class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;

        return (getKth(nums1, 0, nums1.length, nums2, 0, nums2.length, left) +
                getKth(nums1, 0, nums1.length, nums2, 0, nums2.length, right)) / 2.0;
    }

    private int getKth(int[] left, int leftStart, int leftLength, 
            int[] right, int rightStart, int rightLength, int k) {
        if (leftLength > rightLength) {
            return getKth(right, rightStart, rightLength,
                left, leftStart, leftLength, k);
        }

        if (leftLength == 0) {
            return right[rightStart + k - 1];
        }

        if (k == 1) {
            return Math.min(left[leftStart], right[rightStart]);
        }

        int i = Math.min(leftLength, k / 2);
        int j = Math.min(rightLength, k / 2);

        if (left[leftStart + i - 1] > right[rightStart + j - 1]) {
            return getKth(left, leftStart, leftLength, right, rightStart + j, rightLength - j, k - j);
        } else {
            return getKth(left, leftStart + i, leftLength - i, right, rightStart, rightLength, k - j);
        }
    }
}
