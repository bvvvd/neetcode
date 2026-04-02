class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> nonOverlapingIntervals = new LinkedList<>();
        for (int[] interval: intervals) {
            if (nonOverlapingIntervals.isEmpty() 
                || nonOverlapingIntervals.getLast()[1] <= interval[0]) {
                nonOverlapingIntervals.add(interval);
            } else {
                if (nonOverlapingIntervals.getLast()[1] > interval[1]) {
                    nonOverlapingIntervals.removeLast();
                    nonOverlapingIntervals.add(interval);
                }
            }
        }

        return intervals.length - nonOverlapingIntervals.size();
    }

    // [1 2]
    // [1    4]
    //   [2  4]
}
