class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.unite(edge);
        }

        return uf.countComponents();
    }

    private class UnionFind {
        private final int[] nodes;
        private final int[] rank;
        private int componentCount;

        UnionFind(int n) {
            nodes = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
            componentCount = n;
        }

        void unite(int[] connection) {
            int leftRoot = findRoot(connection[0]);
            int rightRoot = findRoot(connection[1]);

            if (leftRoot == rightRoot) {
                return;
            }

            if (rank[leftRoot] < rank[rightRoot]) {
                nodes[leftRoot] = rightRoot;
            } else if (rank[leftRoot] > rank[rightRoot]) {
                nodes[rightRoot] = leftRoot;
            } else {
                nodes[rightRoot] = leftRoot;
                rank[leftRoot]++;
            }

            componentCount--;
        }

        private int findRoot(int node) {
            if (node != nodes[node]) {
                nodes[node] = findRoot(nodes[node]);
            }
            return nodes[node];
        }

        int countComponents() {
            return componentCount;
        }
    }
}
