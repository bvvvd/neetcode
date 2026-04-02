class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> seenChars = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            seenChars.put(currentChar, seenChars.getOrDefault(currentChar, 0) + 1);

            while (getRequiredReplacements(seenChars) > k) {
                char leftChar = s.charAt(left);
                int leftCharCounter = seenChars.get(leftChar);
                if (leftCharCounter == 1) {
                    seenChars.remove(leftChar);
                } else {
                    seenChars.put(leftChar, leftCharCounter - 1);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }


        return Math.max(max, s.length() - left);
    }

    private int getRequiredReplacements(Map<Character, Integer> seenChars) {
        int sum = 0;
        int max = 0;
        for (int value: seenChars.values()) {
            max = Math.max(max, value);
            sum += value;
        }

        return sum - max;
    }
}
