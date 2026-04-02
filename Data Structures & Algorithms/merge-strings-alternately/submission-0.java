class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left = 0;
        int right = 0;

        StringBuilder builder = new StringBuilder();
        while (left < word1.length() || right < word2.length()) {
            if (left < word1.length()) {
                builder.append(word1.charAt(left));
                left++;
            }

            if (right < word2.length()) {
                builder.append(word2.charAt(right));
                right++;
            }
        }

        return builder.toString();
    }
}