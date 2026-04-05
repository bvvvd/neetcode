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
        private int componentCount;

        UnionFind(int n) {
            nodes = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
            componentCount = n;
        }

        void unite(int[] connection) {
            int leftRoot = findRoot(connection[0]);
            int rightRoot = findRoot(connection[1]);

            if (leftRoot != rightRoot) {
                nodes[rightRoot] = leftRoot;
                componentCount--;
            }
        }

        private int findRoot(int node) {
            while (node != nodes[node]) {
                node = nodes[node];
            }
            return node;
        }

        int countComponents() {
            return componentCount;
        }
    }
}
