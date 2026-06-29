class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h: heights) {
            count[h]++;
        }

        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < count[i]; j++) {
                expected.add(i);
            }
        }
        int mismatches = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected.get(i)) {
                mismatches++;
            }
        }

        return mismatches;
    }
}