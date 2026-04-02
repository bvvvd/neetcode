class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] windowMaximums = new int[nums.length - k + 1];
        LinkedList<Integer> window = new LinkedList<>();
        int index = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!window.isEmpty() && nums[window.getLast()] < nums[right]) {
                window.pollLast();
            }
            window.addLast(right);

            if (index > window.getFirst()) {
                window.removeFirst();
            }

            if (right + 1 >= k) {
                windowMaximums[index] = nums[window.getFirst()];
                index++;
            }
        }

        return windowMaximums;
    }
}
