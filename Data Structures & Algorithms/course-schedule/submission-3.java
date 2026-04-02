class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0) + 1);
            dependencies.putIfAbsent(prerequisite[1], new ArrayList<>());
            dependencies.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (!inDegree.containsKey(course)) {
                queue.add(course);
            }
        }
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int dependent: dependencies.getOrDefault(course, Collections.emptyList())) {
                int degree = inDegree.get(dependent);
                if (degree == 1) {
                    inDegree.remove(dependent);
                    queue.add(dependent);
                } else {
                    inDegree.put(dependent, degree - 1);
                }
            }
            completedCourses++;
        }

        return completedCourses == numCourses;
    }
}
