class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (!seen.add(currentChar)) {
                max = Math.max(seen.size(), max);

                while (s.charAt(left) != currentChar) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.add(currentChar);
                left++;
            }
        }

        return Math.max(seen.size(), max);
    }
}
