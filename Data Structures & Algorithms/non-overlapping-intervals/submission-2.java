class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = Integer.MIN_VALUE;
        int removed = 0;
        for (int[] interval: intervals) {
            if (end <= interval[0]) {
                end = interval[1];
            } else {
                end = Math.min(end, interval[1]);
                removed++;
            }
        }

        return removed;
    }

    // [1 2]
    // [1    4]
    //   [2  4]
}
