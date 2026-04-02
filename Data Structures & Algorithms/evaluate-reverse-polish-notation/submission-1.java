class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                values.push(values.pop() + values.pop());
            } else if (token.equals("*")) {
                values.push(values.pop() * values.pop());
            } else if (token.equals("-")) {
                int right = values.pop();
                values.push(values.pop() - right);
            } else if (token.equals("/")) {
                int right = values.pop();
                values.push(values.pop() / right);
            } else {
                values.push(Integer.valueOf(token));
            }
        }

        return values.pop();
    }
}
