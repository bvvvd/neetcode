class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[right.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[right.length - 1 - i] = right[right.length - i] * nums[nums.length - i]; 
        }
        int[] products = new int[nums.length];
        for (int i = 0; i < products.length; i++) {
            products[i] = left[i] * right[i];
        }

        return products;
    }
}  
