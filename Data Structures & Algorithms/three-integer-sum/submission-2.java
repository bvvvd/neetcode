class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int pivot = 0; pivot < nums.length; pivot++) {
            if (pivot == 0 || nums[pivot] != nums[pivot - 1]) {
                int left = pivot + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[pivot];

                    if (sum == 0) {
                        triplets.add(List.of(nums[pivot], nums[left], nums[right]));

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
        }

        return triplets;
    }
}
