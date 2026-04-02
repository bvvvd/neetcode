class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        for (String token: path.split("/")) {
            if (token.isBlank() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.add(token);
            }
        }

        return "/" + String.join("/", stack);
    }
}