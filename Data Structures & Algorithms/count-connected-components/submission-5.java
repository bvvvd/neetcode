class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.unite(edge[0], edge[1]);
        }

        return uf.countComponents();
    }

    private class UnionFind {
        private final int[] parents;
        private final int[] rank;
        private int componentCount;

        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            componentCount = n;
        }

        void unite(int left, int right) {
            int leftRoot = findRoot(left);
            int rightRoot = findRoot(right);

            if (leftRoot == rightRoot) {
                return;
            }

            if (rank[leftRoot] < rank[rightRoot]) {
                parents[leftRoot] = rightRoot;
            } else if (rank[leftRoot] > rank[rightRoot]) {
                parents[rightRoot] = leftRoot;
            } else {
                parents[rightRoot] = leftRoot;
                rank[leftRoot]++;
            }

            componentCount--;
        }

        private int findRoot(int node) {
            if (node != parents[node]) {
                parents[node] = findRoot(parents[node]);
            }
            return parents[node];
        }

        int countComponents() {
            return componentCount;
        }
    }
}
