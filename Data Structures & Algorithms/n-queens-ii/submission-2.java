class Solution {
    private int totalCount;
    private int n;
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> diagonal = new HashSet<>();
    private Set<Integer> negativeDiagonal = new HashSet<>(); 

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
                if (columns.contains(column) || diagonal.contains(row + column) || negativeDiagonal.contains(row - column)) {
                    continue;
                }

                columns.add(column);
                diagonal.add(row + column);
                negativeDiagonal.add(row - column);

                backtrack(row + 1);

                columns.remove(column);
                diagonal.remove(row + column);
                negativeDiagonal.remove(row - column);
            }
        }
    }
}