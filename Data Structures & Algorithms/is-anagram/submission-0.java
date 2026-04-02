class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] charFrequencies = new int[26];
        for (char c: s.toCharArray()) {
            charFrequencies[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            if (charFrequencies[c - 'a'] == 0) {
                return false;
            }
            charFrequencies[c - 'a']--;
        }

        return true;
    }
}
