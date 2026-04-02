class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[uniqueIndex] != nums[i]) {
                uniqueIndex++;
                int swap = nums[i];
                nums[i] = nums[uniqueIndex];
                nums[uniqueIndex] = swap; 
            }
        }

        return uniqueIndex + 1;
    }

}