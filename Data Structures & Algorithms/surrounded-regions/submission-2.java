class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[]{i, n - 1});
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                queue.add(new int[]{m - 1, i});
            }
        }

        boolean[][] seen = new boolean[m][n];
        boolean[][] marked = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            seen[i][j] = true;
            marked[i][j] = true;

            for (int[] direction: DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !seen[x][y] && board[x][y] == 'O') {
                    queue.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !marked[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
