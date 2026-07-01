class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequencies = new int[26];
        for (char c: magazine.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for (char c: ransomNote.toCharArray()) {
            frequencies[c - 'a']--;
            if (frequencies[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}