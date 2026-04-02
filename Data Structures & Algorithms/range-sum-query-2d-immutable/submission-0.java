class NumMatrix {
    private final int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < sumMatrix.length; i++) {
            for (int j = 0; j < sumMatrix[i].length; j++) {
                sumMatrix[i][j] = matrix[i][j];
                if (i > 0) {
                    sumMatrix[i][j] += sumMatrix[i - 1][j];
                }
                if (j > 0) {
                    sumMatrix[i][j] += sumMatrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sumMatrix[i][j] -= sumMatrix[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = sumMatrix[row2][col2];
        int top = row1 > 0 ? sumMatrix[row1 - 1][col2] : 0;
        int left = col1 > 0 ? sumMatrix[row2][col1 - 1] : 0;
        int topLeft = row1 > 0 && col1 > 0 ? sumMatrix[row1 - 1][col1 - 1] : 0;
        return total - top - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */