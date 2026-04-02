class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tFrequencies = new HashMap<>();
        Map<Character, Integer> sFrequencies = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tFrequencies.put(t.charAt(i), tFrequencies.getOrDefault(t.charAt(i), 0) + 1);
            // sFrequencies.put(s.charAt(i), sFrequencies.getOrDefault(s.charAt(i), 0) + 1);
        }

        int matches = 0;
        // for (char key: tFrequencies.keySet()) {
            // if (tFrequencies.get(key) <= sFrequencies.getOrDefault(key, 0)) {
                // matches++;
            // }
        // }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int[] borders = new int[2];
        for (int right = 0; right < s.length(); right++) {
            
            char c = s.charAt(right);
            sFrequencies.put(c, sFrequencies.getOrDefault(c, 0) + 1);
            if (tFrequencies.containsKey(c) && tFrequencies.get(c) == sFrequencies.get(c)) {
                matches++;
            } 

            while (matches == tFrequencies.size()) {
                if (minLength > right - left + 1) {
                    borders = new int[]{left, right};
                    minLength = right - left + 1;
                }
                char previousChar = s.charAt(left);
                int prevCharFrequency = sFrequencies.get(previousChar);
                if (prevCharFrequency > 1) {
                    sFrequencies.put(previousChar, prevCharFrequency - 1);
                } else {
                    sFrequencies.remove(previousChar);
                }

                if (tFrequencies.containsKey(previousChar) 
                    && tFrequencies.get(previousChar) == prevCharFrequency) {
                    matches--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(borders[0], borders[1] + 1);
    }
}
