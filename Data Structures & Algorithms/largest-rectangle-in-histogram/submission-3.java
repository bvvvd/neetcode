class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> rectangle = new Stack<>();
        
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (rectangle.isEmpty() || rectangle.peek()[0] <= heights[i]) {
                rectangle.push(new int[]{heights[i], i});
            } else {
                int startIndex = i;
                while (!rectangle.isEmpty() && rectangle.peek()[0] >= heights[i]) {
                    int[] bar = rectangle.pop();
                    startIndex = bar[1];
                    maxArea = Math.max(maxArea, (i - bar[1]) * bar[0]);
                }
                rectangle.push(new int[]{heights[i], startIndex});
            }
        }

        while (!rectangle.isEmpty()) {
            int[] bar = rectangle.pop();
            maxArea = Math.max(maxArea, (heights.length - bar[1]) * bar[0]);
        }

        return maxArea;
    }
}
