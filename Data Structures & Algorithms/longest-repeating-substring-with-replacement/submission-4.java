class Solution {
    public int characterReplacement(String s, int k) {
        int[] seenChars = new int[26];
        int left = 0;
        int max = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            seenChars[currentChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, seenChars[currentChar - 'A']);

            while (right - left + 1- maxFrequency > k) {
                char leftChar = s.charAt(left);
                seenChars[leftChar - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        return max;
    }
}
