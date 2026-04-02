class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new LinkedList<>(), subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, subsets);
            subset.removeLast();
        }
    }
}
