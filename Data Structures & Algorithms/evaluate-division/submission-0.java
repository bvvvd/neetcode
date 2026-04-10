class Solution {
    private Map<String, List<Pair>> adjacent;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adjacent = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).getFirst();
            String b = equations.get(i).getLast();
            adjacent.putIfAbsent(a, new ArrayList<>());
            adjacent.putIfAbsent(b, new ArrayList<>());
            adjacent.get(a).add(new Pair(b, values[i]));
            adjacent.get(b).add(new Pair(a, 1 / values[i]));
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).getFirst();
            String target = queries.get(i).getLast();
            results[i] = bfs(source, target);
        }

        return results;
    }
    private double bfs(String source, String destination) {
        if (!adjacent.containsKey(source) || !adjacent.containsKey(destination)) {
            return -1.0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair(source, 1.0));
        visited.add(source);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.node;
            double weight = current.weight;

            if (node.equals(destination)) {
                return weight;
            }

            for (Pair neighbor: adjacent.get(node)) {
                if (visited.add(neighbor.node)) {
                    queue.add(new Pair(neighbor.node, weight * neighbor.weight));
                }
            }
        }

        return -1.0;
    }

    private record Pair(String node, double weight) {}
}