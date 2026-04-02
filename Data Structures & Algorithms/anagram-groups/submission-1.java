class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String str: strs) {
            String defaultAnagram = buildDefaultAnagram(str);
            groupedAnagrams.computeIfAbsent(defaultAnagram, k -> new ArrayList<>())
                .add(str);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }

    private String buildDefaultAnagram(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
