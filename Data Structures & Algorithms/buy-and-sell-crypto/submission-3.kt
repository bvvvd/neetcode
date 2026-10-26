class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (num in prices) {
            maxProfit = maxOf(num - minPrice, maxProfit)

            minPrice = minOf(minPrice, num)
        }

        return maxProfit
    }
}
