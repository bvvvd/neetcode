class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int right = 0;
        int left = 0;

        while (right < prices.length) {
            while (right < prices.length && prices[right] >= prices[left]) {
                max = Math.max(prices[right] - prices[left], max);
                right++;
            }

            if (right < prices.length && prices[right] < prices[left]) {
                left = right;
            }
        }

        return max;
    }
}
