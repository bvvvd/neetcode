class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> allCombinations = new ArrayList<>();
        backtrack(nums, target, 0, new LinkedList<>(), allCombinations);
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
                combination.add(num);
                backtrack(nums, target - num, i, combination, allCombinations);
                combination.removeLast();
            }
        }
    }
}
