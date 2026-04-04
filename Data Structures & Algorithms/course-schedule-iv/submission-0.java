class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0) + 1);
            dependencies.putIfAbsent(prerequisite[1], new ArrayList<>());
            dependencies.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> totalDependencies = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            if (!inDegree.containsKey(course)) {
                queue.add(course);
                totalDependencies.put(course, new HashSet<>());
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int dependent: dependencies.getOrDefault(course, Collections.emptyList())) {
                int degree = inDegree.get(dependent);
                if (degree == 1) {
                    inDegree.remove(dependent);
                    queue.add(dependent);
                    totalDependencies.putIfAbsent(dependent, new HashSet<>());
                    totalDependencies.get(dependent).addAll(totalDependencies.get(course));
                    totalDependencies.get(dependent).add(course);
                } else {
                    inDegree.put(dependent, degree - 1);
                    totalDependencies.putIfAbsent(dependent, new HashSet<>());
                    totalDependencies.get(dependent).addAll(totalDependencies.get(course));
                    totalDependencies.get(dependent).add(course);
                }
            }
        }

        List<Boolean> responses = new ArrayList<>();
        for (int[] query: queries) {
            responses.add(totalDependencies.getOrDefault(query[0], Collections.emptySet()).contains(query[1])); 
        }
        return responses;
    }
}