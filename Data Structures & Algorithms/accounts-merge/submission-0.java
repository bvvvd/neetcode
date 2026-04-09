class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailToAccId = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccId.containsKey(email)) {
                    uf.union(i, emailToAccId.get(email));
                } else {
                    emailToAccId.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAccId.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            mergedAccounts.add(merged);
        } 

        return mergedAccounts;
    }

    private class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot == bRoot) {
                return;
            }

            if (rank[aRoot] < rank[bRoot]) {
                parent[aRoot] = parent[bRoot]; 
            } else if (rank[aRoot] > rank[bRoot]) {
                parent[bRoot] = parent[aRoot];
            } else {
                parent[bRoot] = parent[aRoot];
                rank[bRoot]++;
            }
        }

        int find(int node) {
            if (node != parent[node]) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }
    }
}