class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> allCombinations = new HashSet<>();
        backtrack(nums, target, 0, new LinkedList<>(), allCombinations);
        return new ArrayList<>(allCombinations);
    }

    private void backtrack(int[] nums, int target, int start, LinkedList<Integer> combination, Set<List<Integer>> allCombinations) {
        if (target == 0) {
            allCombinations.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                if (target < num) {
                    break;
                }
                combination.add(num);
                backtrack(nums, target - num, i, combination, allCombinations);
                combination.removeLast();
            }
        }
    }
}
