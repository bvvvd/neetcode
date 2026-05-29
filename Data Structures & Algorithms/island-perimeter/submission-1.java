class Solution {
    private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                perimeter += countBorders(i, j, grid);
            }
        }

        return perimeter;
    }

    private int countBorders(int i, int j, int[][] grid) {
        if (grid[i][j] == 0) {
            return 0;
        }

        int count = 0;
        for (int[] direction: DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x < 0 || x >= grid.length || y < 0 | y >= grid[x].length || grid[x][y] == 0) {
                count++;
            }
        }

        return count;
    }
}