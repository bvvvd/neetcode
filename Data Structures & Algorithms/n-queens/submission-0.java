class Solution {
    private List<List<String>> solutions;
    private int n;
    private Set<Integer> columns = new HashSet<>();
    private Set<Integer> positiveDiagonal = new HashSet<>();
    private Set<Integer> negativeDiagonal = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solutions = new ArrayList<>();
        this.n = n;

        backtrack(0, board);
        return solutions;
    }

    private void backtrack(int row, char[][] board) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r: board) {
                solution.add(new String(r));
            }
            solutions.add(solution);
        } else {
            for (int column = 0; column < n; column++) {
                if (columns.contains(column) || positiveDiagonal.contains(row + column) 
                    || negativeDiagonal.contains(row - column)) {
                    continue;
                }

                columns.add(column);
                positiveDiagonal.add(row + column);
                negativeDiagonal.add(row - column);
                board[row][column] = 'Q';

                backtrack(row + 1, board);

                columns.remove(column);
                positiveDiagonal.remove(row + column);
                negativeDiagonal.remove(row - column);
                board[row][column] = '.';
            }
        }
    }
}