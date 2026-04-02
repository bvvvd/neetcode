class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        LinkedList<int[]> newIntervals = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        newIntervals.add(newInterval);
        while (i < intervals.length) {
            int[] interval = intervals[i];
            if (newIntervals.getLast()[1] >= interval[0]) {
                newIntervals.getLast()[0] = Math.min(newIntervals.getLast()[0], interval[0]);
                newIntervals.getLast()[1] = Math.max(newIntervals.getLast()[1], interval[1]);
            } else {
                newIntervals.add(interval);
            }
            i++;
        }

        int[][] output = new int[newIntervals.size()][2];
        for (int j = 0; j < output.length; j++) {
            output[j] = newIntervals.getFirst();
            newIntervals.removeFirst();
        }

        return output;
    }
}
