class Solution {
    public int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        int threshold = 1;

        for (int i = 1; i <= n; i++) {
            if (threshold * 2 == i) {
                threshold = i;
            }
            bitCount[i] = bitCount[i - threshold] + 1;
        }

        return bitCount;
    }
}
