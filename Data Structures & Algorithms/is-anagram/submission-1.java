class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] charFrequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFrequencies[s.charAt(i) - 'a']++;
            charFrequencies[t.charAt(i) - 'a']--;
        }
        
        for (int charFrequency: charFrequencies) {
            if (charFrequency != 0) {
                return false;
            }
        }
        return true;
    }
}
