class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                operands.push(operands.pop() + operands.pop());
            } else if (token.equals("*")) {
                operands.push(operands.pop() * operands.pop());
            } else if (token.equals("-")) {
                int right = operands.pop();
                operands.push(operands.pop() - right);
            } else if (token.equals("/")) {
                int right = operands.pop();
                operands.push(operands.pop() / right);
            } else {
                operands.push(Integer.valueOf(token));
            }
        }

        return operands.pop();
    }
}
