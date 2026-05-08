class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        List<Integer> spiral = new ArrayList<>();
        while (spiral.size() < matrix.length * matrix[0].length) {
            for (int i = left; i < right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                spiral.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                spiral.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }

        return spiral; 
    }
}
