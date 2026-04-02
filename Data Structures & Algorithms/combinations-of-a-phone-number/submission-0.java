class Solution {
    private static final Map<Character, List<Character>> mapping
        = Map.of('2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
            );
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank()) {
            return List.of();
        }
        this.digits = digits;

        List<String> combinations = new ArrayList<>();
        backtrack(0, new StringBuilder(), combinations);
        return combinations;
    }

    private void backtrack(int index, StringBuilder builder, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(builder.toString());
        } else {
            for (char letter: mapping.getOrDefault(digits.charAt(index), List.of())) {
                builder.append(letter);
                backtrack(index + 1, builder, combinations);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
