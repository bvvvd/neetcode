class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (carry == 1) {
            int[] sum = new int[digits.length + 1];
            sum[0] = 1;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = digits[i - 1];
            }
            return sum;
        }

        return digits;
    }
}
