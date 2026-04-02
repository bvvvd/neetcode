class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> allCombinations = new ArrayList<>();
        backtrack(candidates, target, 0, new LinkedList<>(), allCombinations);
        return allCombinations;
    }

    private void backtrack(int[] nums, int target, int start, LinkedList<Integer> combination, List<List<Integer>> allCombinations) {
        if (target == 0) {
            allCombinations.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                if (target < num) {
                    break;
                }

                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                combination.add(num);
                backtrack(nums, target - num, i + 1, combination, allCombinations);
                combination.removeLast();
            }
        }
    }
}
