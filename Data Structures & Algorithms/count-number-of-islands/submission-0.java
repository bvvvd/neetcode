class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    traverse(i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void traverse(int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && !visited[i][j] && grid[i][j] == '1') {
            visited[i][j] = true;

            for (int[] direction: DIRECTIONS) {
                traverse(i + direction[0], j + direction[1]);
            }
        }
    }
}
