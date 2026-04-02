class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int right = 0;
        int left = 0;

        int maxProfit = 0;
        while (right < prices.length) {
            while (right + 1 < prices.length && prices[right + 1] >= prices[right]) {
                right++;
            }

            maxProfit += Math.max(0, prices[right] - prices[left]);
            right++;
            left = right;
        }

        return maxProfit;
    }
}