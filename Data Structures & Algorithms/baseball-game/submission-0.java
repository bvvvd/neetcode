class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();
        for (String operation: operations) {
            if (operation.equals("+")) {
                int right = points.pop();
                int left = points.peek();
                points.push(right);
                points.push(right + left);
            } else if (operation.equals("D")) {
                points.push(points.peek() * 2);
            } else if (operation.equals("C")) {
                points.pop();
            } else {
                int score = Integer.valueOf(operation);

                points.push(score);
            }
        }
        int totalPoints = 0;
        while (!points.isEmpty()) {
            totalPoints += points.pop();
        }
        return totalPoints;
    }
}