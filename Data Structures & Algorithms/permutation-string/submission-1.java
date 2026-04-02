class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] permutation = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            permutation[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < window.length; i++) {
            if (permutation[i] == window[i]) {
                matches++;
            }
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == window.length) {
                return true;
            }

            int index = s2.charAt(i) - 'a';
            window[index]++;

            if (window[index] == permutation[index]) {
                matches++;
            } else if (permutation[index] + 1 == window[index]) {
                matches--;
            }

            index = s2.charAt(i - s1.length()) - 'a';
            window[index]--;
            if (permutation[index] == window[index]) {
                matches++;
            } else if (permutation[index] - 1 == window[index]) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}
