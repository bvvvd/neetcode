class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int writer = nums1.length - 1;
        int leftReader = m - 1;
        int rightReader = n - 1;

        while (leftReader >= 0 || rightReader >= 0) {
            int number = 0;
            if (rightReader < 0) {
                number = nums1[leftReader];
                leftReader--;
            } else if (leftReader < 0) {
                number = nums2[rightReader];
                rightReader--;
            } else if (nums1[leftReader] > nums2[rightReader]) {
                number = nums1[leftReader];
                leftReader--;
            } else {
                number = nums2[rightReader];
                rightReader--;
            }
            nums1[writer] = number;
            writer--;
        }
    }
}