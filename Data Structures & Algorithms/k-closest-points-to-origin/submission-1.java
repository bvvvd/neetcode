class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> closestPoints 
            = new PriorityQueue<>((a, b) -> Long.compare(distance(b), distance(a)));

        for (int[] point: points) {
            if (closestPoints.size() < k) {
                closestPoints.add(point);
            } else if (distance(point) < distance(closestPoints.peek())) {
                closestPoints.poll();
                closestPoints.add(point);
            }
        }

        int[][] output = new int[k][2];
        for (int i = 0; i < output.length; i++) {
            output[i] = closestPoints.poll();
        }

        return output;
    }

    private long distance(int[] point) {
        return 0L + point[0] * point[0] + point[1] * point[1];
    }
}
