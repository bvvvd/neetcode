class Solution {
    public int[] getOrder(int[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        int[] order = new int[tasks.length];

        PriorityQueue<int[]> heap 
            = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] 
                    ? Integer.compare(a[1], b[1])
                    : Integer.compare(a[0], b[0]));
        int i = 0;
        int index = 0;
        long time = tasks[0][0];
        while (i < tasks.length || !heap.isEmpty()) {
            while (i < tasks.length && time >= tasks[i][0]) {
                heap.add(new int[] {tasks[i][1], tasks[i][2]});
                i++;
            }
            if (heap.isEmpty()) {
                time = tasks[i][0];
            } else {
                int[] task = heap.poll();
                time += task[0];
                order[index] = task[1];
                index++;
            }
        }

        return order;
    }
}