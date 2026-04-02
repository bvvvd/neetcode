class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] windowMaximums = new int[nums.length - k + 1];
        PriorityQueue<int[]> window = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            window.offer(new int[]{nums[i], i});

            if (i >= k - 1) {
                while (window.peek()[1] <= i - k) {
                    window.poll();
                }

                windowMaximums[index] = window.peek()[0];
                index++;
            }
        }

        return windowMaximums;
    }
}
