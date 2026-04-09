class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Integer>[] adjacent = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacent[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            adjacent[edge[0]].add(edge[1]);
            adjacent[edge[1]].add(edge[0]);
        }
        int[] edgeCount = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            edgeCount[i] = adjacent[i].size();
            if (edgeCount[i] == 1) {
                leaves.add(i);
            }
        }
        
        while (!leaves.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(leaves);
            }

            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int node = leaves.poll();
                n--;
                for (int neighbor: adjacent[node]) {
                    edgeCount[neighbor]--;
                    if (edgeCount[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>();
    }
}