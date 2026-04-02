class Solution {
    private int n;
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> positiveDiagonal = new HashSet<>();
    private Set<Integer> negativeDiagonal = new HashSet<>();
    private int totalCount;

    public int totalNQueens(int n) {
        this.n = n;
        backtrack(0);
        return totalCount;
    }

    private void backtrack(int row) {
        if (row == n) {
            totalCount++;
        } else {
            for (int column = 0; column < n; column++) {
                if (columns.contains(column) || positiveDiagonal.contains(row + column) 
                    || negativeDiagonal.contains(row - column)) {
                    continue;
                }

                columns.add(column);
                positiveDiagonal.add(row + column);
                negativeDiagonal.add(row - column);

                backtrack(row + 1);

                columns.remove(column);
                positiveDiagonal.remove(row + column);
                negativeDiagonal.remove(row - column);
            }
        }
    }
}