class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];

            for (int[] direction: DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[x][y] = grid[i][j] + 1;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
