class Solution {
    private int[] nums;
    private int targetSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        if (totalSum % k != 0) {
            return false;
        }
        targetSum = totalSum / k;
        Arrays.sort(nums);
        if (targetSum < nums[nums.length - 1]) {
            return false;
        }
        
        return backtrack(nums.length - 1, new int[k]);
    }

    private boolean backtrack(int index, int[] groups) {
        if (index < 0) {
            for (int group: groups) {
                if (group != targetSum) {
                    return false;
                }
            }

            return true;
        } else {
            int number = nums[index];
            Set<Integer> alreadyAttempted = new HashSet<>();
            for (int i = 0; i < groups.length; i++) {
                if (alreadyAttempted.add(groups[i]) && groups[i] + number <= targetSum) {
                    groups[i] += number;
                    if (backtrack(index - 1, groups)) {
                        return true;
                    }
                    groups[i] -= number;
                }
            }

            return false;
        }
    }
}