class Solution {
    public int[] getConcatenation(int[] nums) {
        if (nums == null) {
            return null;
        }

        int[] concatenation = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            concatenation[i] = nums[i];
            concatenation[i + nums.length] = nums[i];
        }
        return concatenation;
    }
}