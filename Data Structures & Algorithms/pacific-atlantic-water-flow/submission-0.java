class Solution {
    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        boolean[][] pacific = pacific();
        boolean[][] atlantic = atlantic();

        List<List<Integer>> both = new ArrayList<>();
        for (int i = 0; i < pacific.length; i++) {
            for (int j = 0; j < pacific[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    both.add(List.of(i, j));
                }
            }
        }

        return both;
    }

    private boolean[][] pacific() {
        boolean[][] reachable = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            traverse(i, 0, reachable);
        }
        for (int j = 0; j < heights[0].length; j++) {
            traverse(0, j, reachable);
        }
        return reachable;
    }

    private boolean[][] atlantic() {
        boolean[][] reachable = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            traverse(i, heights[0].length - 1, reachable);
        }
        for (int j = 0; j < heights[0].length; j++) {
            traverse(heights.length - 1, j, reachable);
        }
        return reachable;
    }

    private void traverse(int i, int j, boolean[][] reachable) {
        reachable[i][j] = true;

        for (int[] direction: DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && x < heights.length && y >= 0 && y < heights[x].length && !reachable[x][y] && heights[x][y] >= heights[i][j]) {
                traverse(x, y, reachable);
            }
        }
    }
}
