class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();
        for (String token: operations) {
            if (token.equals("+")) {
                int top = points.pop();
                int newScore = top + points.peek();
                points.push(top);
                points.push(newScore);
            } else if (token.equals("D")) {
                points.push(points.peek() * 2);
            } else if (token.equals("C")) {
                points.pop();
            } else {
                points.push(Integer.valueOf(token));
            }
        }

        int totalScore = 0;
        while (!points.isEmpty()) {
            totalScore += points.pop();
        }
        return totalScore;
    }
}