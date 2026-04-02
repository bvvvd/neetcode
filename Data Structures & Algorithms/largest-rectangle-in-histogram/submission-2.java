class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            if (stack.isEmpty() || stack.peek()[1] < currentHeight) {
                stack.push(new int[]{i, currentHeight});
            } else if (stack.peek()[1] > currentHeight) {

                int lastBarIndex = i - 1;
                while (!stack.isEmpty() && stack.peek()[1] > currentHeight) {
                    int[] bar = stack.pop();
                    lastBarIndex = bar[0];
                    max = Math.max(max, bar[1] * (i - bar[0]));
                }
                
                stack.push(new int[]{lastBarIndex, currentHeight});
            }
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();

            max = Math.max(max, (heights.length - bar[0]) * bar[1]);
        }

        return max;
    }
}
