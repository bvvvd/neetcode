class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> quadriplets = new ArrayList<>();
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    long sum = 0L + nums[a] + nums[b] + nums[c] + nums[d];

                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        // if (!(nums[a] == nums[b] && nums[b] == nums[c] && nums[c] == nums[d])) {
                            quadriplets.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        // }

                        do { 
                            c++;
                        } while (c < d && nums[c] == nums[c - 1]);
                        do {
                            d--;
                        } while (c < d && nums[d] == nums[d + 1]);
                    }
                }
            }
        }

        return quadriplets;
    }
}