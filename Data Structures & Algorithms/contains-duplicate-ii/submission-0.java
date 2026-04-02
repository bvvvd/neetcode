class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer previous = window.get(nums[i]);
            if (previous != null) {
                if (i - previous <= k) {
                    return true;
                }
            }
            window.put(nums[i], i);
        }
        
        return false;
    }
}