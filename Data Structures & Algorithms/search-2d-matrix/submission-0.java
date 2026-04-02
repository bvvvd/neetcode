class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return Arrays.binarySearch(findArray(matrix, target), target) >= 0;
    }

    private int[] findArray(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int[] midArray = matrix[mid];
            if (target >= midArray[0] && target <= midArray[midArray.length - 1]) {
                return midArray;
            } else if (target < midArray[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{};
    }
}
