class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exists(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exists(int i, int j, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        
        if (index + 1 == word.length()) {
            return true;
        }

        char originalChar = board[i][j];
        board[i][j] = '.';
        for (int[] direction: DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] != '.') {
                if (exists(x, y, index + 1)) {
                    return true;
                }
            }
        }

        board[i][j] = originalChar;
        return false;
    }
}
