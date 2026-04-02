class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfit.add(minCapital.poll()[1]);
            }

            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll();
        }

        return w;
    }
} 