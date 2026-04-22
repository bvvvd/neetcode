class Solution {
    public int hammingWeight(int n) {
        int hamming = 0;
        for (int i = 0; i < 32; i++) {
            hamming += n % 2;
            n /= 2;
        }

        return hamming;
    }
}
