class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> allCombinations = new HashSet<>();
        backtrack(nums, target, new LinkedList<>(), allCombinations);
        return new ArrayList<>(allCombinations);
    }

    private void backtrack(int[] nums, int target, LinkedList<Integer> combination, Set<List<Integer>> allCombinations) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            List<Integer> validCombination = new ArrayList<>(combination);
            Collections.sort(validCombination);
            allCombinations.add(validCombination);
        } else {
            for (int num: nums) {
                combination.add(num);
                backtrack(nums, target - num, combination, allCombinations);
                combination.removeLast();
            }
        }
    }
}
