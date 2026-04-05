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

        UnionFind(int n) {
            nodes = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
        }

        void unite(int[] connection) {
            int leftRoot = findRoot(connection[0]);
            int rightRoot = findRoot(connection[1]);

            if (leftRoot != rightRoot) {
                nodes[rightRoot] = leftRoot;
            }
        }

        private int findRoot(int node) {
            while (node != nodes[node]) {
                node = nodes[node];
            }
            return node;
        }

        int countComponents() {
            int componentCount = 0;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == i) {
                    componentCount++;
                }
            }
            return componentCount;
        }
    }
}
