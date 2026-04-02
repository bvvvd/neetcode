class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> grids = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char cellValue = board[i][j];

                if (cellValue == '.') {
                    continue;
                }

                if (!rows.computeIfAbsent(i, key -> new HashSet<>()).add(cellValue)
                    || !columns.computeIfAbsent(j, key -> new HashSet<>()).add(cellValue)
                    || !grids.computeIfAbsent((i / 3) + ":" + (j / 3), key -> new HashSet<>()).add(cellValue)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
