class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            if (!uf.unite(edge[0], edge[1])) {
                return false;
            };
        }

        return uf.countComponents() == 1;
    }

    private class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int componentCount;

        UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            componentCount = n;
        }

        boolean unite(int left, int right) {
            int leftRoot = findRoot(left);
            int rightRoot = findRoot(right);

            if (leftRoot == rightRoot) {
                return false;
            }

            if (rank[leftRoot] > rank[rightRoot]) {
                parent[rightRoot] = parent[leftRoot];
            } else if (rank[leftRoot] < rank[rightRoot]) {
                parent[leftRoot] = parent[rightRoot];
            } else {
                parent[rightRoot] = parent[leftRoot];
                rank[rightRoot]++;
            }
            componentCount--;
            return true;
        }

        private int findRoot(int node) {
            if (node != parent[node]) {
                parent[node] = findRoot(parent[node]);
            }

            return parent[node];
        }

        int countComponents() {
            return componentCount;
        }
    }
}
