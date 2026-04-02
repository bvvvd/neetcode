class NumMatrix {
    private final int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                prefixSum[i][j] = matrix[i][j];

                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }

                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalAreaSum = prefixSum[row2][col2];

        int leftSubArea = col1 > 0 ? prefixSum[row2][col1 - 1] : 0;
        int topSubArea = row1 > 0 ? prefixSum[row1 - 1][col2] : 0;
        int corner = row1 > 0 && col1 > 0 ? prefixSum[row1 - 1][col1 - 1] : 0;

        return totalAreaSum - leftSubArea - topSubArea + corner;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */