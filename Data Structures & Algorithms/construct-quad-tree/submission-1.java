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

    public Node construct(int[][] grid) {
        prefix = prefix(grid);

        return build(0, 0, prefix.length - 1, prefix.length - 1);
    }

    private int[][] prefix(int[][] grid) {
        int[][] prefixSum = new int[grid.length][grid.length];
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum.length; j++) {
                prefixSum[i][j] += grid[i][j];

                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }

                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }

        return prefixSum;
    }

    private Node build(int topX, int topY, int bottomX, int bottomY) {
        int squareSum = prefix[bottomX][bottomY];
        if (topX > 0) {
            squareSum -= prefix[topX - 1][bottomY];
        }
        if (topY > 0) {
            squareSum -= prefix[bottomX][topY - 1];
        }
        if (topX > 0 && topY > 0) {
            squareSum += prefix[topX - 1][topY - 1];
        }

        if (squareSum == 0) {
            return new Node(false, true);
        }
        if (squareSum == (bottomY - topY + 1) * (bottomY - topY + 1)) {
            return new Node(true, true);
        }

        int midX = topX + (bottomX - topX) / 2;
        int midY = topY + (bottomY - topY) / 2;
        return new Node(
            true,
            false,
            build(topX, topY, midX, midY),
            build(topX, midY + 1, midX, bottomY),
            build(midX + 1, topY, bottomX, midY),
            build(midX + 1, midY + 1, bottomX, bottomY)
        );
    }
}