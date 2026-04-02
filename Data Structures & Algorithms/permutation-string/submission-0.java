class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] permutation = new int[26];
        for (char c: s1.toCharArray()) {
            permutation[c - 'a']++;
        }

        int[] window = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            window[c - 'a']++;

            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (equal(window, permutation)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean equal(int[] one, int[] another) {
        for (int i = 0; i < one.length; i++) {
            if (one[i] != another[i]) {
                return false;
            }
        }

        return true;
    }
}
