class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));
        int currentLoad = 0;
        for (int[] trip: trips) {
            while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) {
                currentLoad -= heap.poll()[0];
            }
            if (trip[0] > capacity || currentLoad + trip[0] > capacity) {
                return false;
            }
            heap.add(trip);
            currentLoad += trip[0];
        }

        return true;
    }
}