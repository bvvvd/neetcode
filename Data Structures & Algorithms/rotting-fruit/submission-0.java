class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottingQueue = new LinkedList<>();
        int oranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottingQueue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    oranges++;
                }
            }
        }

        int minutesElapsed = 0;
        while (!rottingQueue.isEmpty()) {
            int size = rottingQueue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] cell = rottingQueue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] direction: DIRECTIONS) {
                    int x = r + direction[0];
                    int y = c + direction[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        oranges--;
                        rottingQueue.add(new int[]{x, y});
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) {
                minutesElapsed++;
            }
        }

        return oranges == 0 ? minutesElapsed : -1;
    }
}
