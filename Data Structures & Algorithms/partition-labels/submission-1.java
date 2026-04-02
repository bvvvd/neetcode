class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] charIndexes = new int[26][];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (charIndexes[c - 'a'] == null) {
                charIndexes[c - 'a'] = new int[]{i, i};
            } else {
                charIndexes[c - 'a'][1] = i;
            }
        }
        List<int[]> intervals = new ArrayList<>();
        for (int[] charIndex: charIndexes) {
            if (charIndex != null) {
                intervals.add(charIndex);
            }
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        mergedIntervals.add(intervals.getFirst());
        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);

            if (interval[0] <= mergedIntervals.getLast()[1]) {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            } else {
                mergedIntervals.add(interval);
            }
        }

        List<Integer> lengths = new ArrayList<>();
        for (int[] interval: mergedIntervals) {
            lengths.add(interval[1] - interval[0] + 1);
        }

        return lengths;
    }
}
