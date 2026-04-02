class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int max = 0;
        for (int num: nums) {
            int currentLength = 0;
            while (set.contains(num)) {
                // set.remove(num);
                num = num + 1;
                currentLength++;
            }

            max = Math.max(currentLength, max);
        }

        return max;
    }
}
