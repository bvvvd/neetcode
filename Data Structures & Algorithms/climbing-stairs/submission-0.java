class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int previous = 1;
        int current = 2;

        for (int i = 3; i <= n; i++) {
            int next = current + previous;
            previous = current;
            current = next;
        }

        return current;
    }
}
