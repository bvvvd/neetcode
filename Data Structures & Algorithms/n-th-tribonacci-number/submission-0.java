class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }

        int current = 1;
        int preOne = 1;
        int preTwo = 0;
        for (int i = 3; i <= n; i++) {
            int next = preTwo + preOne + current;
            preTwo = preOne;
            preOne = current;
            current = next;
        }

        return current;
    }
}