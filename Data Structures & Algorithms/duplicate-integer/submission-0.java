class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> seenNumbers = new HashSet<>();
        for (int num: nums) {
            if (!seenNumbers.add(num)) {
                return true;
            }
        }

        return false;
    }
}