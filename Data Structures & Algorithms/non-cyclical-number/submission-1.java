class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = reduce(n);

        while (slow != 1) {
            slow = reduce(slow);
            fast = reduce(fast);
            if (slow == fast && slow != 1) {
                return false;
            }
            fast = reduce(fast);
        }

        return true;
    }

    private int reduce(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
