class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                int[] previous = merged.getLast();
                previous[0] = Math.min(previous[0], interval[0]);
                previous[1] = Math.max(previous[1], interval[1]);
            }
        }

        return merged.toArray(new int[][]{});
    }
}
