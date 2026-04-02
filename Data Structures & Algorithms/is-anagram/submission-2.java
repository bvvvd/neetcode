class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sCharFrequencies = new int[26];
        int[] tCharFrequencies = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharFrequencies[s.charAt(i) - 'a']++;
            tCharFrequencies[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sCharFrequencies.length; i++) {
            if (sCharFrequencies[i] != tCharFrequencies[i]) {
                return false;
            }
        }

        return true;
    }
}
