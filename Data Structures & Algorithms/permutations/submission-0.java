class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), allPermutations, new boolean[nums.length]);
        return allPermutations;
    }

    private void backtrack(int[] nums, LinkedList<Integer> permutation, 
        List<List<Integer>> allPermutations, boolean[] picked) {
        if (permutation.size() == nums.length) {
            allPermutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!picked[i]) {
                    permutation.add(nums[i]);
                    picked[i] = true;
                    backtrack(nums, permutation, allPermutations, picked);
                    picked[i] = false;
                    permutation.removeLast();
                }
            }
        }
    }
}
