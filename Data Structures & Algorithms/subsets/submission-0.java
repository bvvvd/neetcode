class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        backtrack(nums, 0, subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int i, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            return;
        }

        var subsetCopy = new ArrayList<>(subsets);
        for (var subset: subsetCopy) {
            var newSubset = new ArrayList<>(subset);
            newSubset.add(nums[i]);
            subsets.add(newSubset);
        }
        
        backtrack(nums, i + 1, subsets);
    }
}
