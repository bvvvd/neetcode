class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), all);
        return all;
    }

    private void backtrack(int n, int open, int closed, StringBuilder builder, List<String> all) {
        if (builder.length() == n * 2) {
            if (open == closed) {
                all.add(builder.toString());
            }
        } else {
            if (open + 1 >= closed) {
                builder.append('(');
                backtrack(n, open + 1, closed, builder, all);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (open >= closed + 1) {
                builder.append(')');
                backtrack(n, open, closed + 1, builder, all);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
