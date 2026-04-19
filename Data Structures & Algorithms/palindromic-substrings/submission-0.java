class Solution {
    private int counter;

    public int countSubstrings(String s) {
        counter = 0;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // odd length
            expand(s, i, i + 1);   // even length
        }

        return counter;
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            counter++;
            left--;
            right++;
        }
    }
}