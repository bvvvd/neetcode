class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int left = 0;
        int right = 0;

        while (left < word1.length() && right < word2.length()) {
            builder.append(word1.charAt(left)).append(word2.charAt(right));
            left++;
            right++;
        }

        while (left < word1.length()) {
            builder.append(word1.charAt(left));
            left++;
        }
        while (right < word2.length()) {
            builder.append(word2.charAt(right));
            right++;
        }

        return builder.toString();
    }
}