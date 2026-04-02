class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        backtrack(nums, new LinkedList<>(), permutations);
        return new ArrayList<>(permutations);
    }

    private void backtrack(int[] nums, LinkedList<Integer> permutation, Set<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.MIN_VALUE) {
                    int original = nums[i];
                    nums[i] = Integer.MIN_VALUE;
                    permutation.add(original);
                    backtrack(nums, permutation, permutations);
                    nums[i] = original;
                    permutation.removeLast();
                }
            }
        }
    }
}