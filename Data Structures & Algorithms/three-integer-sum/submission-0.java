class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int anchor = 0; anchor < nums.length - 2; anchor++) {
            if (anchor > 0 && nums[anchor] == nums[anchor - 1]) {
                continue;
            }

            int left = anchor + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[anchor] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(List.of(nums[anchor], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }
}
