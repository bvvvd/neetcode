class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];
        for (char task: tasks) {
            taskFrequencies[task - 'A']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int frequency: taskFrequencies) {
            if (frequency != 0) {
                heap.add(frequency);
            }
        }

        int cycles = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!heap.isEmpty() || !q.isEmpty()) {
            cycles++;
            if (heap.isEmpty()) {
                cycles = q.peek()[1];
            } else {
                int frequency = heap.poll() - 1;
                if (frequency > 0) {
                    q.add(new int[] {frequency, cycles + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == cycles) {
                heap.add(q.poll()[0]);
            }
        }

        return cycles;
    }
}
