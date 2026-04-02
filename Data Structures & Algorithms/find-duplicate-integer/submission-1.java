class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;
        do {
            slow2 = nums[slow2];
            slow = nums[slow];
        } while (slow != slow2);

        return slow;
    }
}
