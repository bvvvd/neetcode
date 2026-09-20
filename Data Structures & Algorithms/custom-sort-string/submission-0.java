class Solution {
    public String customSortString(String order, String s) {
        int[] frequencies = new int[26];
        for (char c: s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (char c: order.toCharArray()) {
            builder.repeat(c, frequencies[c - 'a']);
            frequencies[c - 'a'] = 0;
        }
        for (int i = 0; i < frequencies.length; i++) {
            builder.repeat((char) (i + 'a'), frequencies[i]);
        }

        return builder.toString();
    }
}