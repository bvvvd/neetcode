class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str: strs) {
            String defaultForm = defaultForm(str);

            groups.computeIfAbsent(defaultForm, (value) -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    private String defaultForm(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
