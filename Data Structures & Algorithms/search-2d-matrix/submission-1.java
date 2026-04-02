class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] array = findArray(matrix, target);

        return findTarget(array, target);
    }

    private int[] findArray(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int[] array = matrix[mid];
            if (array[0] <= target && array[array.length - 1] >= target) {
                return array;
            } else if (array[0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{};
    }

    private boolean findTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
