class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> grids = new HashMap<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currentChar = board[i][j];

                if (currentChar != '.') {
                    if (!rows.containsKey(i)) {
                        rows.put(i, new HashSet<>());
                    }

                    if (!rows.get(i).add(currentChar)) {
                        return false;
                    }

                    if (!columns.containsKey(j)) {
                        columns.put(j, new HashSet<>());
                    }

                    if (!columns.get(j).add(currentChar)) {
                        return false;
                    }

                    String gridKey = i / 3 + ":" + j / 3;
                    if (!grids.containsKey(gridKey)) {
                        grids.put(gridKey, new HashSet<>());
                    }

                    if (!grids.get(gridKey).add(currentChar)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
