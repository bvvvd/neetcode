class Solution {
    private int xor = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return xor;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset) {
        int subsetXor = 0;
        for (int num : subset) {
            subsetXor ^= num;
        }
        xor += subsetXor;
        
        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(nums, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}