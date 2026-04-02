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
        
        return backtrack(0, new int[k]);
    }

    private boolean backtrack(int index, int[] groups) {
        if (index == nums.length) {
            for (int group: groups) {
                if (group != targetSum) {
                    return false;
                }
            }

            return true;
        } else {
            int number = nums[index];

            for (int i = 0; i < groups.length; i++) {
                if (groups[i] + number <= targetSum) {
                    groups[i] += number;
                    if (backtrack(index + 1, groups)) {
                        return true;
                    }
                    groups[i] -= number;
                }

                if (groups[i] == 0) {
                    break;
                }
            }

            return false;
        }
    }
}