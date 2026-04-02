class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] indexedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] minIntervals = new int[queries.length];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] - a[0] + 1));
        int i = 0;
        for (int[] q: indexedQueries) {
            while (i < intervals.length && intervals[i][0] <= q[0]) {
                heap.add(intervals[i]);
                i++;
            }
            while (!heap.isEmpty() && heap.peek()[1] < q[0]) {
                heap.poll();
            }

            minIntervals[q[1]] = heap.isEmpty() ? -1 : (heap.peek()[1] - heap.peek()[0] + 1);
        }
        return minIntervals;
    }
}
