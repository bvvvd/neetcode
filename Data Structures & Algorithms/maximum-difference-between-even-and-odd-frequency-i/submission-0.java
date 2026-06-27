class Solution {
    public int maxDifference(String s) {
        int[] frequencies = new int[26];
        for (char c: s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        int minEven = s.length();
        int maxOdd = 0;

        for (int frequency: frequencies) {
            if (frequency != 0 && frequency % 2 == 0) {
                minEven = Math.min(frequency, minEven);
            } else {
                maxOdd = Math.max(frequency, maxOdd);
            }
        }

        return maxOdd - minEven;
    }
}