class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int writer = m + n - 1;

        while (left >= 0 || right >= 0) {
            if (left < 0) {
                nums1[writer] = nums2[right];
                right--;
                writer--;
            } else if (right < 0) {
                nums1[writer] = nums1[left];
                left--;
                writer--;
            } else if (nums1[left] < nums2[right]) {
                nums1[writer] = nums2[right];
                right--;
                writer--;
            } else {
                nums1[writer] = nums1[left];
                left--;
                writer--;
            }
        }
    }
}