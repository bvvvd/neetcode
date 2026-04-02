/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private int[][] prefix;
    private int n;

    public Node construct(int[][] grid) {
        n = grid.length;
        prefix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }

                if (i > 0) {
                    prefix[i][j] += prefix[i - 1][j];
                }

                if (j > 0) {
                    prefix[i][j] += prefix[i][j - 1];
                }

                prefix[i][j] += grid[i][j];
            }
        }

        return construct(0, 0, n - 1, n - 1);
    }

    private Node construct(int x1, int y1, int x2, int y2) {
        int sum = prefix[x2][y2];

        if (x1 > 0 && y1 > 0) {
            sum += prefix[x1 - 1][y1 - 1];
        }

        if (x1 > 0) {
            sum -= prefix[x1 - 1][y2];
        }

        if (y1 > 0) {
            sum -= prefix[x2][y1 - 1];
        }

        if (sum == 0) {
            return new Node(false, true);
        } else if (sum == (x2 - x1 + 1) * (y2 - y1 + 1)) {
            return new Node(true, true);
        }

        int midX = x1 + (x2 - x1) / 2;
        int midY = y1 + (y2 - y1) / 2;
        Node topLeft = construct(x1, y1, midX, midY);
        Node topRight = construct(x1, midY + 1, midX, y2);
        Node bottomLeft = construct(midX + 1, y1, x2, midY);
        Node bottomRight = construct(midX + 1, midY + 1, x2, y2);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}