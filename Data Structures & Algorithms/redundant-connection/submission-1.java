class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge: edges) {
            if (!uf.unite(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[]{};
    }

    private class UnionFind {
        private int[] parent;
        private int[] rank;
        
        UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        boolean unite(int a, int b) {
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);

            if (aRoot == bRoot) {
                return false;
            }

            if (rank[aRoot] < rank[bRoot]) {
                parent[aRoot] = bRoot;
            } else if (rank[aRoot] > rank[bRoot]) {
                parent[bRoot] = aRoot;
            } else {
                parent[aRoot] = bRoot;
                rank[bRoot]++;
            }

            return true;
        }

        private int findRoot(int node) {
            if (node != parent[node]) {
                parent[node] = findRoot(parent[node]);
            }
            return parent[node];
        }
    }
}
