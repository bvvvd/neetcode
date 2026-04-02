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
        int[] charFrequencies = new int[26];
        for (char c: str.toCharArray()) {
            charFrequencies[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charFrequencies.length; i++) {
            builder.append(i)
                .append('#')
                .append(charFrequencies[i])
                .append(';');
        }
        return builder.toString();
    }
}
