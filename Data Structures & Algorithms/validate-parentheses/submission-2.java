class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }

        Stack<Character> openBrackets = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                openBrackets.push(c);
            } else if (openBrackets.isEmpty() 
                || c == ')' && openBrackets.peek() != '('
                || c == '}' && openBrackets.peek() != '{'
                || c == ']' && openBrackets.peek() != '[') {
                return false;
            } else {
                openBrackets.pop();
            }
        }

        return openBrackets.isEmpty();
    }
}
