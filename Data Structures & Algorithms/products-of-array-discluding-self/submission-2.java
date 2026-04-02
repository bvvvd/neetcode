class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[right.length - 1 - i] 
                = right[right.length - i] * nums[right.length - i];
        }

        int[] productsExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productsExceptSelf[i] = left[i] * right[i];
        }
        return productsExceptSelf;
    }
}  
